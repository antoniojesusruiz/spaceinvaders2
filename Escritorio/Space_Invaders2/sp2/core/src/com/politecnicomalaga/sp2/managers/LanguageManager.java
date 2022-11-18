package com.politecnicomalaga.sp2.managers;

public class LanguageManager {
    public enum Lang{SPANISH,ENGLISH};
    private static Lang activeLanguage;

    public static final int SPANISH_LABEL = 0;
    public static final int ENGLISH_LABEL = 1;
    public static final int PLAY_LABEL = 2;
    public static final int SETTING_LABEL = 3;

    private static final String[] spanishTexts = {"ESPAÑOL", "INGLES", "JUGAR", "CONFIGURACION"};
    private static final String[] englishTexts = {"SPANISH", "ENGLISH", "PLAY","SETTING"};

    private static LanguageManager singleton;

    //Asegura que solo haya una instancia en la clase
    public static LanguageManager getSingleton() {

        if (singleton == null) {
            singleton = new LanguageManager();
            activeLanguage = Lang.SPANISH;   //Lenguaje por defecto
        }
        return singleton;
    }

    //Cambio de idoma
    public void setActionLenguaje(Lang lang){
        activeLanguage = lang;
    }

    //Devuelve el texto correspondiente en el idioma configurado
    public String getString(int uiDescription){
        if (activeLanguage == Lang.SPANISH){
            return spanishTexts[uiDescription];
        }else{
            return englishTexts[uiDescription];
        }
    }

}
