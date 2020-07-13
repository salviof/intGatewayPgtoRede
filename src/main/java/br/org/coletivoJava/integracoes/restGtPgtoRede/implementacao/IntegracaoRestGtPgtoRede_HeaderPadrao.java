package br.org.coletivoJava.integracoes.restGtPgtoRede.implementacao;

import br.com.userede.erede.Environment;
import br.com.userede.erede.Store;
import br.com.userede.erede.eRede;
import br.org.coletivoJava.integracoes.gatewayPgto.api.FabConfigApiRede;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.ConfigGeral.arquivosConfiguracao.ConfigModulo;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoHeaderBuilder;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.transmissao_recepcao_rest_client.ItfAcaoApiRest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.apache.http.HttpHeaders;

public class IntegracaoRestGtPgtoRede_HeaderPadrao
        extends
        AcaoApiIntegracaoHeaderBuilder {

    public IntegracaoRestGtPgtoRede_HeaderPadrao(final ItfAcaoApiRest pAcao) {
        super(pAcao);
    }
    private static final ConfigModulo CONFIGURACAO_REDE = SBCore.getConfigModulo(FabConfigApiRede.class);
    public static final Store STORE = new Store(CONFIGURACAO_REDE.getPropriedade(FabConfigApiRede.FILIACAO),
            CONFIGURACAO_REDE.getPropriedade(FabConfigApiRede.TOKEN),
            getAmbiente(CONFIGURACAO_REDE.getPropriedade(FabConfigApiRede.AMBIENTE))
    );

    private static Environment getAmbiente(String pValor) {
        if (pValor.toLowerCase().startsWith("prod")) {
            return Environment.production();
        } else {
            return Environment.sandbox();
        }
    }

    @Override
    public void buildHeaderPadrao() {
        String credentials = Base64.getEncoder()
                .encodeToString(String.format("%s:%s", STORE.getFiliation(), STORE.getToken()).getBytes(
                        StandardCharsets.UTF_8));

        cabecalho.put(HttpHeaders.USER_AGENT, String.format(eRede.USER_AGENT, STORE.getFiliation()));
        cabecalho.put(HttpHeaders.ACCEPT, "application/json");
        cabecalho.put(HttpHeaders.CONTENT_TYPE, "application/json");
        cabecalho.put(HttpHeaders.AUTHORIZATION, "Basic " + credentials);

    }

}
