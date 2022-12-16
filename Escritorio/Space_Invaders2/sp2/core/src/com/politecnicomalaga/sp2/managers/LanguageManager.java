package com.politecnicomalaga.sp2.managers;

public class LanguageManager {
    public enum Lang{SPANISH,ENGLISH};
    private static Lang activeLanguage;

    public static final int SPANISH_LABEL = 0;
    public static final int ENGLISH_LABEL = 1;
    public static final int PLAY_LABEL = 2;
    public static final int SETTING_LABEL = 3;
    public static final int EXIT_LABEL = 4;
    public static final int CREDITS_LABEL = 5;
    public static final int SPLASH_LABEL = 6;
    public static final int GAMEOVER_LABEL = 7;

    private static final String[] spanishTexts = {"ESPANOL", "INGLES", "JUGAR", "CONFIGURACION", "SALIR", "CREDITOS", "SPACEINVADER", "FIN DEL JUEGO"};
    private static final String[] englishTexts = {"SPANISH", "ENGLISH", "PLAY","SETTINGS", "EXIT", "CREDITS", "SPACEINVADER", "GAMEOVER"};

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
