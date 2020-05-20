package com.sopan.navigationdemo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tools {

    public static final String[] categories = new String[]{"মোলের ধারণা", "Newton's 3rd law",
            "অবতল দর্পন", "লক্ষ্যবস্তুর অবস্থান নির্ণয়", "অমূলদ সংখ্যা", "আধান", "আলোর প্রতিসরণাঙ্ক", "ইলেক্ট্রন বিন্যাস",
            "গোলীয় দর্পন", "দ্বিপদ নামকরণ", "বন্ধনশক্তি", "ভরসংখা", "মোলার আয়তন", "স্প্রিং এর দোলনকাল"};

    public static final String[] archives = new String[]{"June", "July",
            "August", "September", "October", "November", "December", "January",
            "February", "March", "April", "May"};

    public static final String[] archiveYear = new String[]{"2019", "2019",
            "2019", "2019", "2019", "2019", "2019", "2020",
            "2020", "2020", "2020", "2020"};

    public static final String[] topAnserer = new String[]{"Abdul Baset Shahid", "Shammi Akter Diba",
            "Sopan Ahmed", "Zahidul Islam", "Moniruzzaman", "Nayeem Bin Tazem Ali Khan", "Rifat Al Faysal"};

    public static final String[] topUsernames = new String[]{"@shahid", "@Shammi",
            "@theEagle", "@zahid123", "@monir123", "@nayeem123", "@rifat1"};

    public static List<QuestionModel> getLatestQuestionsList(String type) {

        List<QuestionModel> latestQuestionList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {

            Random rand = new Random(); //instance of random class
            int upperbound = 25;
            //generate random values from 0-25
            int int_random = rand.nextInt(upperbound);

            QuestionModel friend = new QuestionModel();
            friend.userId = "user 12" + i;
            friend.questionTitle = "আধান সম্পর্কিত গাণিতিক সমস্যা কিভাবে সহজে সমাধান করা যায়? " + i;
            friend.quetionAuthor = "Post Date: May 26, 2019, Posted By : user12" + i;
            friend.questionDetails = "5 কুলম্বের আধান থেকে 0.5m দূরবর্তী কোনো বিন্দুতে তড়িৎ ক্ষেত্রের তীব্রতা কত?এই গাণিতিক সমস্যাটি সমাধান করতে সাহায্য করুন। " + i;
            friend.questionAnswer = "" + int_random;
            latestQuestionList.add(friend);
        }

        return latestQuestionList;

    }

    public static List<QuestionModel> getNotAnsweredList() {

        List<QuestionModel> notAnsweredList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            QuestionModel friend = new QuestionModel();
            friend.userId = "user 12" + i;
            friend.questionTitle = "দুইটি মাধ্যমের প্রতিসরণাঙ্ক কিভাবে নির্ণয় করতে হয়? " + i;
            friend.quetionAuthor = "Post Date: May 26, 2019, Posted By : user12" + i;
            friend.questionDetails = "a ও b দুটি মাধ্যমের পরম প্রতিসরণাঙ্ক যথাক্রমে 1.9 এবং 2.3 হলে aমাধ্যমের সাপেক্ষে b মাধ্যমের প্রতিসরণাঙ্ক কিভাবে " + i;
            friend.questionAnswer = "0";
            notAnsweredList.add(friend);
        }

        return notAnsweredList;

    }

    public static List<QuestionModel> getMostPopularList() {

        List<QuestionModel> mostPopularList = new ArrayList<>();

        for (int i = 0; i < 25; i++) {

            Random rand = new Random(); //instance of random class
            int upperbound = 50;
            //generate random values from 0-24
            int int_random = rand.nextInt(upperbound);

            QuestionModel friend = new QuestionModel();
            friend.userId = "user 12" + i;
            friend.questionTitle = "মোলার আয়তন সম্পর্কিত গাণিতিক সমস্যা বুঝিয়ে দিন " + i;
            friend.quetionAuthor = "Post Date: May 22, 2019, Posted By : user12" + i;
            friend.questionDetails = "17.75 gm সোডিয়াম সালফেট 250 ml দ্রবণে দ্রবীভূত থাকলে, দ্রবণের ঘনমাত্রা কিভাবে বের করা যায়? " + i;
            friend.questionAnswer = "" + int_random;
            mostPopularList.add(friend);
        }

        return mostPopularList;
    }

    public static List<QuestionModel> getTagInfoList() {

        List<QuestionModel> tagInfoList = new ArrayList<>();

        for (int i = 0; i < categories.length; i++) {

            Random rand = new Random(); //instance of random class
            int upperbound = 3;
            //generate random values from 0-24
            int int_random = rand.nextInt(upperbound);

            if(int_random == 0){
                int_random = 1;
            }

            QuestionModel friend = new QuestionModel();
            friend.questionTitle = categories[i];
            friend.questionDetails = "No. of Questions : " + int_random;
            tagInfoList.add(friend);
        }

        return tagInfoList;
    }

    public static List<QuestionModel> getArchiveList() {

        List<QuestionModel> tagInfoList = new ArrayList<>();

        for (int i = 0; i < archives.length; i++) {

            QuestionModel friend = new QuestionModel();
            friend.questionTitle = archives[i];
            friend.questionDetails = archiveYear[i];
            tagInfoList.add(friend);
        }

        return tagInfoList;
    }

    public static List<QuestionModel> getTopAnswererList() {

        List<QuestionModel> topAnswererList = new ArrayList<>();

        for (int i = 0; i < topAnserer.length; i++) {

            QuestionModel friend = new QuestionModel();
            friend.questionTitle = topAnserer[i];
            friend.questionDetails = topUsernames[i];
            topAnswererList.add(friend);
        }

        return topAnswererList;
    }
}
