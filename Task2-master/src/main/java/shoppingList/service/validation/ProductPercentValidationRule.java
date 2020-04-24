package shoppingList.service.validation;

import shoppingList.domain.Product;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
@Component
public class ProductPercentValidationRule implements ProductValidationRule {
    final int minPricePercent=0;
    @Override
    public void validate (Product product){
        checkNotNull(product);
        BigDecimal bigDecimalNull = new BigDecimal("0");
        BigDecimal bigDecimalThousand = new BigDecimal("100");
        if (product.getPercent().compareTo(bigDecimalNull)<minPricePercent ||
                product.getPercent().compareTo(bigDecimalThousand)>minPricePercent){
            throw new ProductValidationException("Percent is not correct. Please enter percent that is more than 0 " +
                    "and less or equal to 100.");
        }
    }
}