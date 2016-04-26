/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.DAO;

//import java.util.Date;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Antonio Junior
 */
@Converter(autoApply = true)
public class ConvertLocalDateForDate implements AttributeConverter<LocalDate, Date>{

//  @Override
//    public Date convertToDatabaseColumn(LocalDate date) {
//        Instant instant = Instant.from(date);
//        return Date.from(instant);
//    }
//
//    @Override
//    public LocalDate convertToEntityAttribute(Date value) {
//        Instant instant = value.toInstant();
//        return LocalDate.from(instant);
//    }
    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
        return (locDate == null ? null : Date.valueOf(locDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        return (sqlDate == null ? null : sqlDate.toLocalDate());
    }

}
