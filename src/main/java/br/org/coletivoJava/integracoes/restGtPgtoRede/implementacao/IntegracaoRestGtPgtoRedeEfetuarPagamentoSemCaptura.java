package br.org.coletivoJava.integracoes.restGtPgtoRede.implementacao;

import br.com.userede.erede.Transaction;
import br.com.userede.erede.TransactionResponse;
import br.com.userede.erede.eRede;
import br.com.userede.erede.service.error.RedeException;
import br.org.coletivoJava.integracoes.restGtPgtoRede.api.InfoIntegracaoRestGtPgtoRedeTransacoes;
import br.org.coletivoJava.integracoes.gatewayPgto.api.FabApiRestGatewayPgtoRedeTransacoes;
import br.org.coletivojava.erp.gatewayPagamento.ItfCartaoCreditoDadosTransient;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.RespostaWebServiceRestIntegracao;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteRest;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

@InfoIntegracaoRestGtPgtoRedeTransacoes(tipo = FabApiRestGatewayPgtoRedeTransacoes.EFETUAR_PAGAMENTO_SEM_CAPTURA)
public class IntegracaoRestGtPgtoRedeEfetuarPagamentoSemCaptura
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestGtPgtoRedeEfetuarPagamentoSemCaptura(
            final FabTipoAgenteClienteRest pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(
                FabApiRestGatewayPgtoRedeTransacoes.EFETUAR_PAGAMENTO_SEM_CAPTURA,
                pTipoAgente, pUsuario, pParametro);
    }

    @Override
    protected void executarAcao() {

        Double d = (Double) parametros[0];
        String codigoTransacao = (String) parametros[1];
        ItfCartaoCreditoDadosTransient cartao = (ItfCartaoCreditoDadosTransient) parametros[2];
        String mesVencimento = cartao.getValidadeCartao().substring(0,
                cartao.getValidadeCartao().indexOf("/"));
        String anoVencimento = cartao.getValidadeCartao().substring(cartao.getValidadeCartao().indexOf("/") + 1,
                cartao.getValidadeCartao().length());

        Transaction transaction = new Transaction(d, codigoTransacao)
                .creditCard(
                        cartao.getNumeroCartao(),
                        cartao.getDigitoVerificador(),
                        mesVencimento,
                        anoVencimento,
                        cartao.getNomeUsuario()
                );
        transaction.setCapture(Boolean.FALSE);

        try {
            TransactionResponse respErede = (new eRede(IntegracaoRestGtPgtoRede_HeaderPadrao.STORE).create(transaction));

            if (respErede.getReturnCode().equals("00")) {
                System.out.println(respErede.getTid());
                resposta = new RespostaWebServiceRestIntegracao(respErede.getReturnMessage(), 200);
                resposta.addAviso("Transacao Realizada com sucesso");
                resposta.setRetorno(respErede);

            }
        } catch (RedeException rede) {
            resposta = new RespostaWebServiceRestIntegracao(rede.getRedeError().getReturnMessage(), Integer.valueOf(rede.getRedeError().getReturnCode()));
            SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, rede.getRedeError().getReturnMessage(), rede);

        }

    }
}
