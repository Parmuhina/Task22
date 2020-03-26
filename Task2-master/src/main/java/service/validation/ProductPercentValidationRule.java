package service.validation;

import domain.Product;
import java.math.BigDecimal;

public class ProductPercentValidationRule implements ProductValidationPercentRule {

    @Override
    public void validatePercent (Product product){
        checkNotNull(product);
        BigDecimal bigDecimalNull = new BigDecimal("0");
        BigDecimal bigDecimalThousand = new BigDecimal("100");
        if (product.getPercent().compareTo(bigDecimalNull)<0 ||
                product.getPercent().compareTo(bigDecimalThousand)>0){
            throw new ProductValidationException("Percent is not correct. Please enter percent that is more than 0 " +
                    "and less or equal to 100.");
        }
    }
}