package shoppingList.service.validation;

import shoppingList.domain.Product;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {

    final int minPricePercent=0;
    @Override
    public void validate(Product product){
        checkNotNull(product);
        BigDecimal bigDecimalNull = new BigDecimal("0");
        if (product.getPrice().compareTo(bigDecimalNull)<=minPricePercent){

            throw new ProductValidationException("Price is not correct. Please enter price that is more than 0.");
        }
    }
}

