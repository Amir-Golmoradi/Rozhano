package wisepup.customer_service.domain.valueObjects;

public record CustomerId(String value) {
    public static CustomerId of(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer Id cannot be null or empty");
        }
        return new CustomerId(value);
    }
}
