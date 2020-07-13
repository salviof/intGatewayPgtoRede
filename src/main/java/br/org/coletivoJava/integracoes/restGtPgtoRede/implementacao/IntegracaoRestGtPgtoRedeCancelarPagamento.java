package br.org.coletivoJava.integracoes.restGtPgtoRede.implementacao;

import br.org.coletivoJava.integracoes.restGtPgtoRede.api.InfoIntegracaoRestGtPgtoRedeTransacoes;
import br.org.coletivoJava.integracoes.gatewayPgto.api.FabApiRestGatewayPgtoRedeTransacoes;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreNumeros;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteRest;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestGtPgtoRedeTransacoes(tipo = FabApiRestGatewayPgtoRedeTransacoes.CANCELAR_PAGAMENTO)
public class IntegracaoRestGtPgtoRedeCancelarPagamento
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestGtPgtoRedeCancelarPagamento(
            final FabTipoAgenteClienteRest pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestGatewayPgtoRedeTransacoes.CANCELAR_PAGAMENTO,
                pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        double pValor = (double) parametros[1];
        String valor = UtilSBCoreNumeros.converterNumeroToStrMoedaPadraoBanco(pValor);
        return "{\n" + "  \"amount\": " + valor + "}";
    }

    @Override
    public String gerarUrlRequisicao() {
        String codigoTransacao = (String) parametros[0];
        return IntegracaoRestGtPgtoRede_HeaderPadrao.STORE.getEnvironment().getEndpoint("transactions") + "/" + codigoTransacao;
    }

}
