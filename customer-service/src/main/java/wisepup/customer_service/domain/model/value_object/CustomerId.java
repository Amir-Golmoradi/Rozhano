package wisepup.customer_service.domain.model.value_object;

import org.springframework.util.Assert;

import java.util.UUID;

public record CustomerId(UUID id) {

    public CustomerId {
        Assert.notNull(id, "id cannot be null");
    }

    public CustomerId() {
        this(UUID.randomUUID());
    }
}
