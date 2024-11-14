
# Define services
services=("auth-service" "product-service" "order-service" "payment-service" "inventory-service")

# Base folders to create for each service
folders=(
    "src/main/java/com/example/{service_name}/application/dto"
    "src/main/java/com/example/{service_name}/application/port"
    "src/main/java/com/example/{service_name}/application/service"
    "src/main/java/com/example/{service_name}/domain/model"
    "src/main/java/com/example/{service_name}/domain/repository"
    "src/main/java/com/example/{service_name}/domain/aggregate"
    "src/main/java/com/example/{service_name}/infrastructure/adapter/persistence"
    "src/main/java/com/example/{service_name}/infrastructure/adapter/messaging"
    "src/main/java/com/example/{service_name}/infrastructure/config"
    "src/main/java/com/example/{service_name}/presentation/controller"
)

# Create folders for each service
for service in "${services[@]}"; do
    echo "Creating folders for $service..."
    
    for folder in "${folders[@]}"; do
        mkdir -p "$service/$folder"
    done
    
    # Create pom.xml
    touch "$service/pom.xml"
    
    echo "Done creating folders for $service"
done

echo "Folder creation completed for all services!"