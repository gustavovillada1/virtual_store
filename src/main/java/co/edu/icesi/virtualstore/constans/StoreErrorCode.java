package co.edu.icesi.virtualstore.constans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StoreErrorCode {

    I_C_01("El nombre del item no debe ser mayor a 100 caracteres"),
    I_C_02("La descripción del item no debe ser mayor a 900 caracteres"),
    I_C_03("El nombre del item no debe estar vacio."),
    I_C_04("La descripción del item está vacía"),
    I_C_05("El precio debe ser mayor a 0"),
    I_S_01("El id del item ingresado no existe"),


    U_C_01("El correo y telefono no pueden estar ambos vacios. Llenar al menos uno"),
    U_C_02("El patrón del correo no es valido"),
    U_C_03("El patrón del telefono no es valido"),
    U_S_01("Este correo ya esta en uso"),
    U_S_02("Este telefono ya esta en uso"),
    U_S_03("El rol ingresado no existe"),
    U_S_04("El usuario ingresado no se encuentra registrado"),
    U_C_05("El nombre ingresado está vacío"),
    U_C_06("La descripción ingresada está vacía"),
    U_C_07("El nombre ingresado es muy corto"),
    U_C_08("La descripción ingresada es muy corta"),


    O_C_01("El estado ingresado no existe"),
    O_C_02("El total debe ser mayor a 0"),
    O_S_01("La orden ingresada no existe"),

    O_S_02("El usuario ingresado no se encuentra registrado");

    private final String errorMessage;

}