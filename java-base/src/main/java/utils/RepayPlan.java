package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class RepayPlan {

    private final Logger logger = LoggerFactory.getLogger(RepayPlan.class);

    public static void main(String[] args) throws Exception {
        RepayPlan repayPlan = new RepayPlan();

        repayPlan.DEBJ(1200, 12, 10);

        repayPlan.DEBX(1200, 12, 0.1);
    }


    /**
     * 等额本金贷款计算公式： 每月本息金额 =（贷款本金 / 贷款期数）+（贷款本金 — 累计已还本金）×每月利率
     */
    public void DEBJ(double laonPrincipal, int month, double rate) {
        BigDecimal bigLaonPrincipal = new BigDecimal(laonPrincipal); //贷款本金
        BigDecimal bigmonth = new BigDecimal(month); //贷款期数
        BigDecimal bigRate = new BigDecimal(rate); //每月利率

        BigDecimal monthPrincipal = bigLaonPrincipal.divide(bigmonth, 16, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP); //每月应还本金

        for (int i = 1; i <= month; i++) {
            BigDecimal exactPrincipal = monthPrincipal.multiply(new BigDecimal(i - 1)).setScale(2, BigDecimal.ROUND_HALF_UP); //累计已还本金
            BigDecimal remainPrincipal = bigLaonPrincipal.subtract(exactPrincipal).setScale(2, BigDecimal.ROUND_HALF_UP); //剩余应还本金=贷款本金—累计已还本金
            BigDecimal monthInterest = remainPrincipal.multiply(bigRate.divide(bigLaonPrincipal, 16, BigDecimal.ROUND_HALF_UP)).setScale(2, BigDecimal.ROUND_HALF_UP); //每月应还利息=剩余应还本金*(年利率/贷款期数)
            BigDecimal total = monthPrincipal.add(monthInterest);
            logger.info("第{}个月 应还总额为{} 应还本金为{}  累计已还本金为{}  剩余应还本金{}  应还月利息为{}", i, total, monthPrincipal, exactPrincipal, remainPrincipal, monthInterest);
        }
    }


    /**
     * 等额本息贷款计算公式：每月偿还本息=〔贷款本金×月利率×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数-1〕
     */
    public void DEBX(double laonPrincipal, int month, double yearRate) {
        BigDecimal perMonthPrincipalInterest = RepayPlan.getPerMonthPrincipalInterest(laonPrincipal, yearRate, month);
        logger.info("等额本息---每月还款本息：" + perMonthPrincipalInterest);

        Map<Integer, BigDecimal> mapInterest = RepayPlan.getPerMonthInterest(laonPrincipal, yearRate, month);
        logger.info("等额本息---每月还款利息：" + mapInterest);

        Map<Integer, BigDecimal> mapPrincipal = RepayPlan.getPerMonthPrincipal(laonPrincipal, yearRate, month);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (Map.Entry<Integer, BigDecimal> entry : mapPrincipal.entrySet()) {
            bigDecimal = bigDecimal.add(entry.getValue());
        }
        logger.info("等额本息---贷款总额：" + bigDecimal);

        logger.info("等额本息---每月还款本金：" + mapPrincipal);
    }

    /**
     * 等额本息：每月偿还本金和利息
     * 公式：每月偿还本息=〔贷款本金×月利率×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数-1〕
     *
     * @param laonPrincipal     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 每月偿还本金和利息, 不四舍五入，直接截取小数点最后两位
     */
    public static BigDecimal getPerMonthPrincipalInterest(double laonPrincipal, double yearRate, int totalmonth) {
        double monthRate = yearRate / 12;
        BigDecimal monthIncome = new BigDecimal(laonPrincipal)
                .multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)))
                .divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, RoundingMode.HALF_UP);
        return monthIncome;
    }

    /**
     * 等额本息：每月偿还利息
     * 公式：每月偿还利息=贷款本金×月利率×〔(1+月利率)^还款月数-(1+月利率)^(还款月序号-1)〕÷〔(1+月利率)^还款月数-1〕
     *
     * @param laonPrincipal     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 每月偿还利息
     */
    public static Map<Integer, BigDecimal> getPerMonthInterest(double laonPrincipal, double yearRate, int totalmonth) {
        Map<Integer, BigDecimal> map = new HashMap<>();
        BigDecimal perMonthPrincipalInterest = getPerMonthPrincipalInterest(laonPrincipal, yearRate, totalmonth);
        BigDecimal principal = BigDecimal.ZERO;
        double totalPrincipal = laonPrincipal;
        for (int i = 1; i < totalmonth + 1; i++) {
            BigDecimal currentInterest = getCurrentInterest(laonPrincipal, yearRate);
            map.put(i, currentInterest);
            principal = principal.add(perMonthPrincipalInterest.subtract(currentInterest));
            if (i == totalmonth - 1) {
                laonPrincipal = new BigDecimal(totalPrincipal).subtract(principal).doubleValue();
            } else {
                laonPrincipal = new BigDecimal(laonPrincipal).subtract(perMonthPrincipalInterest.subtract(currentInterest)).doubleValue();
            }
        }
        return map;
    }

    /**
     * 等额本息：当期利息
     *
     * @param previouPrincipal
     * @param yearRate
     * @return
     */
    private static BigDecimal getCurrentInterest(double previouPrincipal, double yearRate) {
        //日利率
        BigDecimal dayRate = new BigDecimal(yearRate).divide(new BigDecimal(360), 8, RoundingMode.HALF_UP);
        //当期利息
        BigDecimal currentInterest = new BigDecimal(previouPrincipal).multiply(dayRate).multiply(new BigDecimal(30));
        return currentInterest.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * 等额本息：每月偿还本金
     *
     * @param laonPrincipal     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 每月偿还本金
     */
    public static Map<Integer, BigDecimal> getPerMonthPrincipal(double laonPrincipal, double yearRate, int totalmonth) {
        Map<Integer, BigDecimal> map = new HashMap<>();
        BigDecimal perMonthPrincipalInterest = getPerMonthPrincipalInterest(laonPrincipal, yearRate, totalmonth);
        BigDecimal principal = BigDecimal.ZERO;
        double totalPrincipal = laonPrincipal;
        for (int i = 1; i < totalmonth + 1; i++) {
            BigDecimal currentInterest = getCurrentInterest(laonPrincipal, yearRate);
            if (i == totalmonth) {
                map.put(i, new BigDecimal(laonPrincipal).setScale(2, RoundingMode.HALF_UP));
            } else {
                map.put(i, perMonthPrincipalInterest.subtract(currentInterest));
            }
            principal = principal.add(perMonthPrincipalInterest.subtract(currentInterest));
            if (i == totalmonth - 1) {
                laonPrincipal = new BigDecimal(totalPrincipal).subtract(principal).doubleValue();
            } else {
                laonPrincipal = new BigDecimal(laonPrincipal).subtract(perMonthPrincipalInterest.subtract(currentInterest)).doubleValue();
            }
        }
        return map;
    }
}