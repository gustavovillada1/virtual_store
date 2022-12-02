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
    I_C_05("El precio debe ser mayor que 0"),
    I_S_01("El id del item ingresado no existe"),


    U_C_01("El correo y telefono no pueden estar ambos vacios. Llenar al menos uno"),
    U_C_02("El patrón del correo no es valido"),
    U_C_03("El patrón del telefono no es valido"),
    U_S_01("Correo ya en uso"),
    U_S_02("Telefono ya en uso"),
    U_S_03("El rol ingresado no existe");

    private final String errorMessage;

}