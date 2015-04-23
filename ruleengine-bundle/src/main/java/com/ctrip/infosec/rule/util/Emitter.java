/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ctrip.infosec.rule.util;

import com.ctrip.infosec.common.model.RiskFact;
import com.ctrip.infosec.common.Constants;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author zhengby
 */
public class Emitter {

    public static void emit(RiskFact fact, int riskLevel, String riskMessage) {
        String ruleNo = (String) fact.ext.get(Constants.key_ruleNo);
        if (!Strings.isNullOrEmpty(ruleNo)) {
            Map<String, Object> result = Maps.newHashMap();
            result.put(Constants.riskLevel, riskLevel);
            result.put(Constants.riskMessage, riskMessage);
            fact.results.put(ruleNo, result);
        }
    }

    public static void emit(RiskFact fact, String riskLevelTxt, String riskMessage) {
        String ruleNo = (String) fact.ext.get(Constants.key_ruleNo);
        if (!StringUtils.isNumeric(riskLevelTxt)) {
            throw new IllegalArgumentException("\"riskLevel\"必须为数字");
        }
        int riskLevel = NumberUtils.toInt(riskLevelTxt);
        if (!Strings.isNullOrEmpty(ruleNo)) {
            Map<String, Object> result = Maps.newHashMap();
            result.put(Constants.riskLevel, riskLevel);
            result.put(Constants.riskMessage, riskMessage);
            fact.results.put(ruleNo, result);
        }
    }

    public static void emit(RiskFact fact, int riskLevel, String riskMessage, String... riskScenes) {
        String ruleNo = (String) fact.ext.get(Constants.key_ruleNo);
        if (!Strings.isNullOrEmpty(ruleNo)) {
            Map<String, Object> result = Maps.newHashMap();
            result.put(Constants.riskLevel, riskLevel);
            result.put(Constants.riskMessage, riskMessage);
            // 风险场景
            if (riskScenes != null && riskScenes.length > 0) {
                result.put(Constants.riskScene, Lists.newArrayList(riskScenes));
            }
            fact.results.put(ruleNo, result);
        }
    }

    public static void emit(RiskFact fact, String riskLevelTxt, String riskMessage, String... riskScenes) {
        String ruleNo = (String) fact.ext.get(Constants.key_ruleNo);
        if (!StringUtils.isNumeric(riskLevelTxt)) {
            throw new IllegalArgumentException("\"riskLevel\"必须为数字");
        }
        int riskLevel = NumberUtils.toInt(riskLevelTxt);
        if (!Strings.isNullOrEmpty(ruleNo)) {
            Map<String, Object> result = Maps.newHashMap();
            result.put(Constants.riskLevel, riskLevel);
            result.put(Constants.riskMessage, riskMessage);
            // 风险场景
            if (riskScenes != null && riskScenes.length > 0) {
                result.put(Constants.riskScene, Lists.newArrayList(riskScenes));
            }
            fact.results.put(ruleNo, result);
        }
    }
}
