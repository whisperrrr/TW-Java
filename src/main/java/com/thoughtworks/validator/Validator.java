package com.thoughtworks.validator;

import com.thoughtworks.exception.WrongInputException;
import com.thoughtworks.answer.Answer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 这个类是验证答案是否是合法的
 * <p>
 * 合法标准：
 * 1.位数是否正确 ---> 定义合适位数属性
 * 2.是否有重复位
 * 3.是否每一位都是数字
 */
// 下面是工具方法的标准写法
//public final class Validator {
//    
//    private Validator() {
//
//    }
//    // 验证输入是否合法
//    public static void validationAnswer() {
//
//    }
//}
// 不过我想定义的灵活一点
public class Validator {
    private int digit;

    public Validator(int digit) {
        this.digit = digit;
    }

    public void validationAnswer(Answer answer) throws WrongInputException {
        int answerLength = answer.getLength();
        String answerStr = answer.getAnswer();
        boolean isValid = true;

        if (answerLength != digit || (!isUnRepeat(answerStr)) || (!isNumber(answerStr))) {
            isValid = false;
        }

        if (!isValid) {
            throw new WrongInputException();
        }
    }

    private boolean isNumber(String answerStr) {
        boolean flag = true;
        for (char c : answerStr.toCharArray()) {
            if (!Character.isDigit(c)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean isUnRepeat(String answerStr) {
        // 方法一，用Set不重复的方法

        Set<String> answerSet = new HashSet<>(Arrays.asList(answerStr.split("")));
        return answerSet.size() == digit;

//        // 方法二，用indexOf
//        boolean flag = true;
//        for (int i = 0; i < answerStr.length(); i++) {
//            if (answerStr.indexOf(answerStr.charAt(i)) != i) {
//                flag = false;
//                break;
//            }
//        }
//        return flag;
    }
}