package br.org.coletivoJava.integracoes.restGtPgtoRede.implementacao;

import br.org.coletivoJava.integracoes.restGtPgtoRede.api.InfoIntegracaoRestGtPgtoRedeTransacoes;
import br.org.coletivoJava.integracoes.gatewayPgto.api.FabApiRestGatewayPgtoRedeTransacoes;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.gestaoToken.GestaoTokenChaveUnica;
import org.json.simple.JSONObject;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteRest;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestGtPgtoRedeTransacoes(tipo = FabApiRestGatewayPgtoRedeTransacoes.EFETUAR_PAGAMENTO_CAPTURA_IMEDIATA)
public class GestaoTokenRestGtPgtoRede extends GestaoTokenChaveUnica {

    @Override
    public String gerarNovoToken() {
        return null;
    }

    @Override
    public String extrairToken(JSONObject jsonObject) {
        return null;
    }

    @Override
    public boolean validarToken() {
        return false;
    }

    public GestaoTokenRestGtPgtoRede(
            final FabTipoAgenteClienteRest pTipoAgente,
            final ItfUsuario pUsuario) {
        super(FabApiRestGatewayPgtoRedeTransacoes.class, pTipoAgente, pUsuario);
    }
}
