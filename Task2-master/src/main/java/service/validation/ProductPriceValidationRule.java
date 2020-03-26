package service.validation;

import domain.Product;
import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationPriceRule {
    @Override
    public void validatePrice(Product product){
        checkNotNull(product);
        BigDecimal bigDecimalNull = new BigDecimal("0");
        if (product.getPrice().compareTo(bigDecimalNull)<=0){

            throw new ProductValidationException("Price is not correct. Please enter price that is more than 0.");
        }
    }
}

