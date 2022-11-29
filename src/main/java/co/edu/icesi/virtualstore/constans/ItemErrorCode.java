package co.edu.icesi.virtualstore.constans;

import lombok.Getter;

@Getter
public class ItemErrorCode {

    public static String CODE_01="Item name should be shorter than 100 characters.";
    public static String CODE_02="Item description should be shorter than 255 characters.";
    public static String CODE_03="Item name is empty";
    public static String CODE_04="Item description is empty";

}