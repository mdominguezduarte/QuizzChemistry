package com.example.quizchemistry

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions() : ArrayList<Question>{

        val questionChemistList = ArrayList<Question>()

        val que1 =Question(1,"En el desarollo de cualquier proceso químico es fundamental",R.drawable.chemistry2,"Rendimiento en su práctica.","Rendimiento teórico.", "Rendimiento teórico y práctica","Todas verdaderas",1)
        val que2 =Question(2,"El rendimiento de un proceso químico está relacionado con?",R.drawable.chemistry3,"Impurezas reactivos","Impurezas productos", "Conversión reactivos y productos incompleta","Todas falsas",3)
        val que3 =Question(3,"En cuáles hay equilibrio químico??",R.drawable.chemistry4,"acidez dela sangre","fotosíntesis", "basicidad de la sangre","todas",4)
        val que4 =Question(4,"Señala cuál es falsa",R.drawable.chemistry5,"Las reacciones químicas son procesos reversibles","Las reacciones químicas son procesos irreversibles", "Los reactivos y productos coexisten en equilibrio a determinadas condiciones","Todas verdaderas",2)
        val que5 =Question(5,"Para el estudio del equilibrio es importante",R.drawable.chemistry6,"Obtención de datos experimentales fiables","Posterior estudio de los datos fiables", "3 experimentos con resultados similares no establecen una ley","Todas verdaderas",4)
        val que6 =Question(6,"En el equilibrio químico...",R.drawable.chemistry7,"La composición de la mezcla no varía con el tiempo","Propiedades macroscópicas constantes", "Se producen dos reacciones opuestas a igual velocidad","Todas verdaderas",4)
        val que7 =Question(7,"La velocidad de reacción disminuye cuándo",R.drawable.chemistry8,"Disminuye la reacción de los productos","aumenta la reación de los reaccionantes", "disminuye la reacción de los reaccionantes","option4",3)
        val que8 =Question(8,"La velocidad de reacción directa e inversa",R.drawable.chemistry9,"Son directamente proporcionales","Inversamente proporcionales", "No son proporcionales","A más producto, menor velocidad",2)


        questionChemistList.add(que1)
        questionChemistList.add(que2)
        questionChemistList.add(que3)
        questionChemistList.add(que4)
        questionChemistList.add(que5)
        questionChemistList.add(que6)
        questionChemistList.add(que7)
        questionChemistList.add(que8)

        return questionChemistList
    }


}