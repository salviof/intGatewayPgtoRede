package br.org.coletivoJava.integracoes.restGtPgtoRede.implementacao;

import br.org.coletivoJava.integracoes.restGtPgtoRede.api.InfoIntegracaoRestGtPgtoRedeTransacoes;
import br.org.coletivoJava.integracoes.gatewayPgto.api.FabApiRestGatewayPgtoRedeTransacoes;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.gestaoToken.GestaoTokenChaveUnica;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenDeAcessoExterno;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ComoUsuario;

@InfoIntegracaoRestGtPgtoRedeTransacoes(tipo = FabApiRestGatewayPgtoRedeTransacoes.EFETUAR_PAGAMENTO_CAPTURA_IMEDIATA)
public class GestaoTokenRestGtPgtoRede extends GestaoTokenChaveUnica {

    @Override
    public boolean validarToken() {
        return false;
    }

    public GestaoTokenRestGtPgtoRede(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario) {
        super(FabApiRestGatewayPgtoRedeTransacoes.class, pTipoAgente, pUsuario);
    }

    @Override
    public ItfTokenDeAcessoExterno gerarNovoToken() {
        return getTokenCompleto();
    }

    @Override
    public ItfTokenDeAcessoExterno loadTokenArmazenado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
