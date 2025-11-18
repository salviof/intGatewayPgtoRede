package br.org.coletivoJava.integracoes.restGtPgtoRede.implementacao;

import br.org.coletivoJava.integracoes.restGtPgtoRede.api.InfoIntegracaoRestGtPgtoRedeTransacoes;
import br.org.coletivoJava.integracoes.gatewayPgto.api.FabApiRestGatewayPgtoRedeTransacoes;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;

import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestGtPgtoRedeTransacoes(tipo = FabApiRestGatewayPgtoRedeTransacoes.CAPTURAR_PAGAMENTO)
public class IntegracaoRestGtPgtoRedeCapturarPagamento
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestGtPgtoRedeCapturarPagamento(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestGatewayPgtoRedeTransacoes.CAPTURAR_PAGAMENTO,
                pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        double valor = (double) parametros[1];
        return "{\n" + "  \"amount\": " + valor + "\n" + "}";
    }

    @Override
    public String gerarUrlRequisicao() {
        String codigoTransacao = (String) parametros[0];
        return IntegracaoRestGtPgtoRede_HeaderPadrao.STORE.getEnvironment().getEndpoint("transactions") + "/" + codigoTransacao;
    }

}
