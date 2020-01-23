
build:
	@echo "Compiling application...."
	mvn clean package

build-docker:
	docker-compose -f docker-compose.yml build

run:
	@echo "Running docker compose...."
	docker-compose -f docker-compose.yml up -d

logs:
	docker-compose -f docker-compose.yml logs -f

stop:
	docker-compose -f docker-compose.yml down