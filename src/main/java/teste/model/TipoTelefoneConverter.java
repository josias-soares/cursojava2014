/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.model;

import javax.persistence.AttributeConverter;
import teste.model.Telefone.Tipo;

public class TipoTelefoneConverter implements AttributeConverter<Telefone.Tipo, String> {

    @Override
    public String convertToDatabaseColumn(Telefone.Tipo tipo) {
        return tipo.getId();
    }

    @Override
    public Telefone.Tipo convertToEntityAttribute(String id) {
        return Tipo.tipoPorId(id);
    }

}
