# Docker Setup for ABM Sucursales

This document explains how to run the ABM Sucursales application using Docker and Docker Compose with MySQL database.

## Prerequisites

- Docker installed on your system
- Docker Compose installed on your system

## Quick Start

1. **Build and start the services:**
   ```bash
   docker-compose up --build
   ```

2. **Access the application:**
   - Application: http://localhost:8080
   - Swagger UI: http://localhost:8080/swagger-ui.html
   - Health Check: http://localhost:8080/actuator/health

3. **Access MySQL database:**
   - Host: localhost
   - Port: 3306
   - Database: abm_sucursales
   - Username: app_user
   - Password: app_password
   - Root password: rootpassword

## Available Commands

### Start services in background
```bash
docker-compose up -d
```

### Stop services
```bash
docker-compose down
```

### Stop services and remove volumes (WARNING: This will delete all data)
```bash
docker-compose down -v
```

### View logs
```bash
# All services
docker-compose logs

# Specific service
docker-compose logs app
docker-compose logs mysql
```

### Rebuild application after code changes
```bash
docker-compose up --build app
```

## Configuration

### Environment Variables

The application uses the following environment variables in Docker:

- `SPRING_PROFILES_ACTIVE=docker` - Activates Docker profile
- `SPRING_DATASOURCE_URL` - MySQL connection URL
- `SPRING_DATASOURCE_USERNAME` - Database username
- `SPRING_DATASOURCE_PASSWORD` - Database password

### Database Configuration

- **Database Name:** abm_sucursales
- **Application User:** app_user / app_password
- **Root User:** root / rootpassword
- **Port:** 3306 (exposed to host)

### Volumes

- `mysql_data` - Persistent storage for MySQL data

## Development

### Local Development vs Docker

- **Local Development:** Uses H2 in-memory database (default profile)
- **Docker Environment:** Uses MySQL database (docker profile)

### Making Changes

1. Make your code changes
2. Rebuild and restart the application:
   ```bash
   docker-compose up --build app
   ```

### Database Initialization

- Initial database schema is created automatically by Hibernate
- Custom initialization scripts can be added to `init-scripts/` directory
- Scripts are executed in alphabetical order when MySQL container starts for the first time

## Troubleshooting

### Application won't start
- Check if MySQL is healthy: `docker-compose logs mysql`
- Verify database connection: `docker-compose logs app`

### Port conflicts
- If port 8080 or 3306 are already in use, modify the ports in `docker-compose.yml`

### Database connection issues
- Ensure MySQL container is fully started before the application
- Check the health check status: `docker-compose ps`

### Reset everything
```bash
docker-compose down -v
docker system prune -f
docker-compose up --build
```

## Production Considerations

For production deployment, consider:

1. **Security:**
   - Change default passwords
   - Use Docker secrets for sensitive data
   - Enable SSL/TLS for database connections

2. **Performance:**
   - Configure MySQL with appropriate settings
   - Set JVM memory limits for the application
   - Use production-ready logging configuration

3. **Monitoring:**
   - Enable additional actuator endpoints
   - Set up proper logging aggregation
   - Configure health checks and alerts
