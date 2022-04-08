/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.gatewayPgto.api;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.ItfFabricaIntegracaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.FabTipoConexaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.InfoConsumoRestService;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.FabTipoAutenticacaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.InfoConfigRestClientIntegracao;
import com.super_bits.modulosSB.SBCore.modulos.ManipulaArquivo.importacao.FabTipoArquivoImportacao;

/**
 *
 * @author desenvolvedorninja01
 * @since 30/01/2020
 * @version 1.0
 */
@InfoConfigRestClientIntegracao(enderecosDocumentacao = "https://rocket.chat/docs/developer-guides/rest-api/",
        tipoAutenticacao = FabTipoAutenticacaoRest.CHAVE_ACESSO_METODOLOGIA_PROPRIA,
        nomeIntegracao = FabConfigApiRede.NOME_INTEGRACAO,
        configuracao = FabConfigApiRede.class
)
public enum FabApiRestGatewayPgtoRedeTransacoes implements ItfFabricaIntegracaoRest {

    @InfoConsumoRestService(getPachServico = "/erede/v1/transactions",
            tipoConexao = FabTipoConexaoRest.POST, tipoInformacaoEnviada = FabTipoArquivoImportacao.JSON,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosPost = {""},
            urlDocumentacao = "https://www.userede.com.br/desenvolvedores/pt/produto/e-Rede#documentacao-metodos")
    EFETUAR_PAGAMENTO_CAPTURA_IMEDIATA,
    @InfoConsumoRestService(getPachServico = "/erede/v1/transactions",
            tipoConexao = FabTipoConexaoRest.POST, tipoInformacaoEnviada = FabTipoArquivoImportacao.JSON,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            urlDocumentacao = "https://www.userede.com.br/desenvolvedores/pt/produto/e-Rede#documentacao-metodos")

    EFETUAR_PAGAMENTO_SEM_CAPTURA,
    @InfoConsumoRestService(getPachServico = "/erede/v1/transactions",
            tipoConexao = FabTipoConexaoRest.POST, tipoInformacaoEnviada = FabTipoArquivoImportacao.JSON,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosPost = {"Valor"},
            parametrosGet = {"codTransacao"},
            urlDocumentacao = "https://www.userede.com.br/desenvolvedores/pt/produto/e-Rede#documentacao-metodos")
    CAPTURAR_PAGAMENTO,
    @InfoConsumoRestService(getPachServico = "/erede/v1/transactions",
            tipoConexao = FabTipoConexaoRest.POST, tipoInformacaoEnviada = FabTipoArquivoImportacao.JSON,
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            parametrosPost = {"Valor"},
            parametrosGet = {"codTransacao"},
            urlDocumentacao = "https://www.userede.com.br/desenvolvedores/pt/produto/e-Rede#documentacao-metodos")
    CANCELAR_PAGAMENTO,

}
