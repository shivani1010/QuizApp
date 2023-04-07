package com.tutrials.quizapp

object Constants {

    fun getQuestion():ArrayList<Question>
    {
    val QuestionList=ArrayList<Question>()
        val Question1=Question(1,"What Country does this flag belong to?",R.drawable.ic_launcher_foreground,
        "Argentina","Australia","Kenya","Austria",1)
        QuestionList.add(Question1)


        val Question2=Question(2,"What Country does this flag belong to?",R.drawable.ic_launcher_foreground,
            "Argentina","Australia","Kenya","Austria",1)
        QuestionList.add(Question2)


        val Question3=Question(3,"What Country does this flag belong to?",R.drawable.ic_launcher_foreground,
            "Argentina","Australia","Kenya","Austria",1)
        QuestionList.add(Question3)


        val Question4=Question(4,"What Country does this flag belong to?",R.drawable.ic_launcher_foreground,
            "Argentina","Australia","Kenya","Austria",1)
        QuestionList.add(Question4)

        val Question5=Question(5,"What Country does this flag belong to?",R.drawable.ic_launcher_foreground,
            "Argentina","Australia","Kenya","Austria",1)
        QuestionList.add(Question5)

        val Question6=Question(6,"What Country does this flag belong to?",R.drawable.ic_launcher_foreground,
            "Argentina","Australia","Kenya","Austria",1)
        QuestionList.add(Question6)

        val Question7=Question(7,"What Country does this flag belong to?",R.drawable.ic_launcher_foreground,
            "Argentina","Australia","Kenya","Austria",1)
        QuestionList.add(Question7)

        val Question8=Question(8,"What Country does this flag belong to?",R.drawable.ic_launcher_foreground,
            "Argentina","Australia","Kenya","Austria",1)
        QuestionList.add(Question8)

        val Question9=Question(9,"What Country does this flag belong to?",R.drawable.ic_launcher_foreground,
            "Argentina","Australia","Kenya","Austria",1)
        QuestionList.add(Question9)

        val Question10=Question(10,"What Country does this flag belong to?",R.drawable.ic_launcher_foreground,
            "Argentina","Australia","Kenya","Austria",1)
        QuestionList.add(Question10)


        return  QuestionList
    }

}