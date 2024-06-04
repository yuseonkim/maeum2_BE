package org.example.maeum2_be._core;

import java.util.Random;

public class RandomMessage {
    private static final String[] MESSAGES = {
            "오늘도 잘해보자!", "힘들 때는 쉬어도 괜찮아.", "포기하지 말고 천천히 해보자.", "괜찮아, 잘 하고 있어.",
            "다 잘될 거야.", "네가 할 수 있다고 믿어.", "항상 네 편이야.", "너의 마음을 이해해.",
            "모든 일에는 시간이 필요해.", "힘들면 언제든 이야기해.", "너는 절대 혼자가 아니야.",
            "오늘 하루도 수고했어.", "너의 감정을 소중히 여겨.", "내일은 더 나을 거야.",
            "하루하루 천천히 나아가자.", "실패는 성공의 일부야.", "너의 속도로 가도 돼.",
            "언제나 네 곁에 있을게.", "천천히 해도 괜찮아.", "너의 마음이 중요해.",
            "어려운 일은 함께 이겨내자.", "늘 널 응원해.", "쉬는 것도 중요한 일이야.",
            "네 자신을 믿어줘.", "항상 노력하는 모습이 멋져.", "너는 소중한 사람이야.",
            "힘들면 잠시 쉬어도 돼.", "네가 자랑스러워.", "항상 네 곁에 있어줄게.",
            "네가 어떤 결정을 하든 응원할게.", "너의 용기를 칭찬해.", "천천히, 꾸준히 해보자.",
            "실패는 성장의 과정이야.", "작은 성공도 축하해줘.", "너는 이겨낼 수 있어.",
            "네가 자랑스러워.", "힘들 땐 언제든 말해줘.", "언제나 네 편이야.",
            "너의 생각을 존중해.", "네가 하는 모든 일이 의미 있어.", "오늘도 잘 버텨줘서 고마워.",
            "네가 있어서 행복해.", "너는 할 수 있어.", "너의 마음을 이해해.",
            "하루하루가 소중해.", "어떤 일이 있어도 널 사랑해.", "네가 얼마나 대단한지 알아?",
            "천천히 해도 괜찮아.", "힘들 때는 잠시 쉬어가자.", "모든 것은 잘 될 거야.",
            "네가 있는 그대로 충분해.", "실패해도 괜찮아.", "작은 성공도 소중해.",
            "너의 속도로 가도 돼.", "너의 노력을 인정해.", "어떤 일이든 다 잘될 거야.",
            "너는 중요한 사람이야.", "오늘 하루도 수고했어.", "너의 감정을 소중히 여겨.",
            "내일은 더 나을 거야.", "어려운 일은 함께 이겨내자.", "늘 널 응원해.",
            "쉬는 것도 중요한 일이야.", "네 자신을 믿어줘.", "항상 노력하는 모습이 멋져.",
            "힘들면 잠시 쉬어도 돼.", "너의 결정을 지지해.", "너의 용기를 칭찬해.",
            "천천히, 꾸준히 해보자.", "작은 성공도 축하해줘.", "너는 이겨낼 수 있어.",
            "네가 자랑스러워.", "언제나 네 곁에 있을게.", "힘들 땐 언제든 말해줘.",
            "네가 하는 모든 일이 의미 있어.", "너의 생각을 존중해.", "오늘도 잘 버텨줘서 고마워.",
            "너는 특별한 사람이야.", "네가 있어서 행복해.", "어떤 일이 있어도 널 사랑해.",
            "너의 마음을 이해해.", "하루하루가 소중해.", "실패해도 괜찮아.",
            "작은 성공도 소중해.", "너의 속도로 가도 돼.", "어떤 일이든 다 잘될 거야.",
            "너는 중요한 사람이야.", "오늘 하루도 수고했어.", "너의 감정을 소중히 여겨.",
            "내일은 더 나을 거야.", "어려운 일은 함께 이겨내자.", "늘 널 응원해.",
            "쉬는 것도 중요한 일이야.", "네 자신을 믿어줘.", "항상 노력하는 모습이 멋져.",
            "힘들면 잠시 쉬어도 돼.", "너의 결정을 지지해.", "너의 용기를 칭찬해.",
            "천천히, 꾸준히 해보자.", "작은 성공도 축하해줘.", "너는 이겨낼 수 있어.",
            "네가 자랑스러워.", "언제나 네 곁에 있을게.", "힘들 땐 언제든 말해줘.",
            "네가 하는 모든 일이 의미 있어.", "너의 생각을 존중해.", "오늘도 잘 버텨줘서 고마워.",
            "너는 특별한 사람이야.", "네가 있어서 행복해.", "어떤 일이 있어도 널 사랑해.",
            "너의 마음을 이해해.", "하루하루가 소중해.", "실패해도 괜찮아.",
            "작은 성공도 소중해.", "너의 속도로 가도 돼.", "어떤 일이든 다 잘될 거야.",
            "너는 중요한 사람이야.", "오늘 하루도 수고했어.", "너의 감정을 소중히 여겨.",
            "내일은 더 나을 거야.", "어려운 일은 함께 이겨내자.", "늘 널 응원해.",
            "쉬는 것도 중요한 일이야.", "네 자신을 믿어줘.", "항상 노력하는 모습이 멋져.",
            "힘들면 잠시 쉬어도 돼.", "너의 결정을 지지해.", "너의 용기를 칭찬해.",
            "천천히, 꾸준히 해보자.", "작은 성공도 축하해줘.", "너는 이겨낼 수 있어.",
            "네가 자랑스러워.", "언제나 네 곁에 있을게.", "힘들 땐 언제든 말해줘.",
            "네가 하는 모든 일이 의미 있어.", "너의 생각을 존중해.", "오늘도 잘 버텨줘서 고마워.",
            "너는 특별한 사람이야.", "네가 있어서 행복해.", "어떤 일이 있어도 널 사랑해.",
            "너의 마음을 이해해.", "하루하루가 소중해.", "실패해도 괜찮아.",
            "작은 성공도 소중해.", "너의 속도로 가도 돼.", "어떤 일이든 다 잘될 거야.",
            "너는 중요한 사람이야.", "오늘 하루도 수고했어.", "너의 감정을 소중히 여겨.",
            "내일은 더 나을 거야.", "어려운 일은 함께 이겨내자.", "늘 널 응원해.",
            "쉬는 것도 중요한 일이야.", "네 자신을 믿어줘.", "항상 노력하는 모습이 멋져.",
            "힘들면 잠시 쉬어도 돼.", "너의 결정을 지지해.", "너의 용기를 칭찬해.",
            "천천히, 꾸준히 해보자.", "작은 성공도 축하해줘.", "너는 이겨낼 수 있어.",
            "네가 자랑스러워.", "언제나 네 곁에 있을게.", "힘들 땐 언제든 말해줘.",
            "네가 하는 모든 일이 의미 있어.", "너의 생각을 존중해.", "오늘도 잘 버텨줘서 고마워.",
            "너는 특별한 사람이야.", "네가 있어서 행복해.", "어떤 일이 있어도 널 사랑해.",
            "너의 마음을 이해해.", "하루하루가 소중해.", "실패해도 괜찮아.",
            "작은 성공도 소중해.", "너의 속도로 가도 돼.", "어떤 일이든 다 잘될 거야.",
            "너는 중요한 사람이야.", "오늘 하루도 수고했어.", "너의 감정을 소중히 여겨.",
            "내일은 더 나을 거야.", "어려운 일은 함께 이겨내자.", "늘 널 응원해.",
            "쉬는 것도 중요한 일이야.", "네 자신을 믿어줘.", "항상 노력하는 모습이 멋져.",
            "힘들면 잠시 쉬어도 돼.", "너의 결정을 지지해.", "너의 용기를 칭찬해.",
            "천천히, 꾸준히 해보자.", "작은 성공도 축하해줘.", "너는 이겨낼 수 있어.",
            "네가 자랑스러워.", "언제나 네 곁에 있을게.", "힘들 땐 언제든 말해줘.",
            "네가 하는 모든 일이 의미 있어.", "너의 생각을 존중해.", "오늘도 잘 버텨줘서 고마워.",
            "너는 특별한 사람이야.", "네가 있어서 행복해.", "어떤 일이 있어도 널 사랑해.",
            "너의 마음을 이해해.", "하루하루가 소중해.", "실패해도 괜찮아.",
            "작은 성공도 소중해.", "너의 속도로 가도 돼.", "어떤 일이든 다 잘될 거야.",
            "너는 중요한 사람이야.", "오늘 하루도 수고했어.", "너의 감정을 소중히 여겨.",
            "내일은 더 나을 거야.", "어려운 일은 함께 이겨내자.", "늘 널 응원해.",
            "쉬는 것도 중요한 일이야.", "네 자신을 믿어줘.", "항상 노력하는 모습이 멋져.",
            "힘들면 잠시 쉬어도 돼.", "너의 결정을 지지해.", "너의 용기를 칭찬해.",
            "천천히, 꾸준히 해보자.", "작은 성공도 축하해줘.", "너는 이겨낼 수 있어.",
            "네가 자랑스러워.", "언제나 네 곁에 있을게.", "힘들 땐 언제든 말해줘.",
            "네가 하는 모든 일이 의미 있어.", "너의 생각을 존중해.", "오늘도 잘 버텨줘서 고마워.",
            "너는 특별한 사람이야.", "네가 있어서 행복해.", "어떤 일이 있어도 널 사랑해.",
            "너의 마음을 이해해.", "하루하루가 소중해.", "실패해도 괜찮아.",
            "작은 성공도 소중해.", "너의 속도로 가도 돼.", "어떤 일이든 다 잘될 거야.",
            "너는 중요한 사람이야.", "오늘 하루도 수고했어.", "너의 감정을 소중히 여겨.",
            "내일은 더 나을 거야.", "어려운 일은 함께 이겨내자.", "늘 널 응원해.",
            "쉬는 것도 중요한 일이야.", "네 자신을 믿어줘.", "항상 노력하는 모습이 멋져.",
            "힘들면 잠시 쉬어도 돼.", "너의 결정을 지지해.", "너의 용기를 칭찬해.",
            "천천히, 꾸준히 해보자.", "작은 성공도 축하해줘.", "너는 이겨낼 수 있어.",
            "네가 자랑스러워.", "언제나 네 곁에 있을게.", "힘들 땐 언제든 말해줘.",
            "네가 하는 모든 일이 의미 있어.", "너의 생각을 존중해.", "오늘도 잘 버텨줘서 고마워.",
            "너는 특별한 사람이야.", "네가 있어서 행복해.", "어떤 일이 있어도 널 사랑해.",
            "너의 마음을 이해해.", "하루하루가 소중해.", "실패해도 괜찮아.",
            "작은 성공도 소중해.", "너의 속도로 가도 돼.", "어떤 일이든 다 잘될 거야.",
            "너는 중요한 사람이야.", "오늘 하루도 수고했어.", "너의 감정을 소중히 여겨.",
            "내일은 더 나을 거야.", "어려운 일은 함께 이겨내자.", "늘 널 응원해.",
            "쉬는 것도 중요한 일이야.", "네 자신을 믿어줘.", "항상 노력하는 모습이 멋져.",
            "힘들면 잠시 쉬어도 돼.", "너의 결정을 지지해.", "너의 용기를 칭찬해.",
            "천천히, 꾸준히 해보자.", "작은 성공도 축하해줘.", "너는 이겨낼 수 있어.",
            "네가 자랑스러워.", "언제나 네 곁에 있을게.", "힘들 땐 언제든 말해줘.",
            "네가 하는 모든 일이 의미 있어.", "너의 생각을 존중해.", "오늘도 잘 버텨줘서 고마워."
    };

    public static void main(String[] args) {
        Random random = new Random();
        String randomMessage = getRandomMessage(random);
        System.out.println(randomMessage);
    }

    public static String getRandomMessage(Random random) {
        int index = random.nextInt(MESSAGES.length);
        return MESSAGES[index];
    }
}
