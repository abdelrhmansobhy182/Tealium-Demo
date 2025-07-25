package frontend.helpers;

import frontend.models.Product;

public class ProductHelper {

    public static Product CreateNewProduct(){

        // Ideally, this method should use the registration API to create a new user
        // and then use the same credentials to perform login.
        // However, since the API is not available right now, a temporary solution is used:
        // Returning static test data from environment variables instead of dynamically registering a user.

        return Product.builder()
                .productName("Dorian Perforated Oxford")
                .build();
    }
}
