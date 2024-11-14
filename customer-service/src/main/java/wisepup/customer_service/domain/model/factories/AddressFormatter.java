package wisepup.customer_service.domain.model.factories;

import wisepup.customer_service.domain.model.value_object.Address;

public class AddressFormatter {

    private AddressFormatter() {
        // Private constructor to prevent instantiation
    }

    public static String format(Address address) {
        return String.format("%s, %s, %s, %s",
                address.getCity(),
                address.getStreet(),
                address.getAlley(),
                address.getZipCode()
        );
    }
}
