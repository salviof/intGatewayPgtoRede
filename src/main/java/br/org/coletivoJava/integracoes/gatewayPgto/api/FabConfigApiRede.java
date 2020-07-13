/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.gatewayPgto.api;

import com.super_bits.modulosSB.SBCore.ConfigGeral.arquivosConfiguracao.ItfFabConfigModulo;

/**
 *
 * @author desenvolvedorninja01
 */
public enum FabConfigApiRede implements ItfFabConfigModulo {

    AMBIENTE,
    FILIACAO,
    TOKEN;
    public static final String NOME_INTEGRACAO = "Gt Pgto Rede";

    @Override
    public String getValorPadrao() {
        return "não configurado";
    }

}
