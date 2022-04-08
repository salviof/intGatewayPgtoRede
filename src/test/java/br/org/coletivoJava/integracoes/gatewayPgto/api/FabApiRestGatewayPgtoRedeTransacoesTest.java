/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.gatewayPgto.api;

import br.org.coletivoJava.integracoes.amazonSMS.ConfiguradorCoreApiUseRede;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.junit.Test;
import testes.geradorCodigo.GeradorImplementacaoIntegracaoRest;
import testes.testesSupers.TestesApiRest;

/**
 *
 * @author desenvolvedorninja01
 */
public class FabApiRestGatewayPgtoRedeTransacoesTest extends TestesApiRest {

    public FabApiRestGatewayPgtoRedeTransacoesTest() {
    }

    /**
     * Test of valueOf method, of class FabApiRestGatewayPgtoRedeTransacoes.
     */
    @Test
    public void testValueOf() {
        SBCore.configurar(new ConfiguradorCoreApiUseRede(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        gerarCodigos(FabApiRestGatewayPgtoRedeTransacoes.class);

    }

}
