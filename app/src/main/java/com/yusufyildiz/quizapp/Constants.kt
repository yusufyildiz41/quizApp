package com.yusufyildiz.quizapp

object Constants{
    fun getQuestions() : ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(
            1,
            "What country does this flag belong to ? ",
            R.drawable.flag_of_argentina,
            "Argentina",
            "Austria",
            "Armenia",
            "Brazil",
            1
        )

        questionList.add(que1)

        val que2 = Question(
            2,
            "What country does this flag belong to ? ",
            R.drawable.flag_of_brazil,
            "Turkey",
            "Belgium",
            "Argentina",
            "Brazil",
            4
        )

        questionList.add(que2)


        val que3 = Question(
            3,
            "What country does this flag belong to ? ",
            R.drawable.flag_of_belgium,
            "Canada",
            "Belgium",
            "Armenia",
            "France",
            2
        )

        questionList.add(que3)

        val que4 = Question(
            4,
            "What country does this flag belong to ? ",
            R.drawable.flag_of_canada,
            "Canada",
            "Belgium",
            "Argentina",
            "Brazil",
            1
        )

        questionList.add(que4)


        val que5 = Question(
            5,
            "What country does this flag belong to ? ",
            R.drawable.flag_of_china,
            "Belgium",
            "India",
            "China",
            "Brazil",
            3
        )

        questionList.add(que5)

        val que6 = Question(
            6,
            "What country does this flag belong to ? ",
            R.drawable.flag_of_denmark,
            "Denmark",
            "Belgium",
            "Turkey",
            "Brazil",
            1
        )

        questionList.add(que6)


        val que7 = Question(
            7,
            "What country does this flag belong to ? ",
            R.drawable.flag_of_spain,
            "Brazil",
            "Egypt",
            "Israel",
            "Spain",
            4
        )

        questionList.add(que7)

        val que8 = Question(
            8,
            "What country does this flag belong to ? ",
            R.drawable.flag_of_turkey,
            "Canada",
            "Italy",
            "Turkey",
            "Brazil",
            3
        )

        questionList.add(que8)

        val que9 = Question(
            9,
            "What country does this flag belong to ? ",
            R.drawable.flag_of_france,
            "India",
            "France",
            "Israel",
            "Spain",
            2
        )

        questionList.add(que9)

        val que10 = Question(
            10,
            "What country does this flag belong to ? ",
            R.drawable.flag_of_england,
            "England",
            "Netherlands",
            "Belgium",
            "America",
            1
        )

        questionList.add(que10)

        return questionList

    }

}