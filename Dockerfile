# Use lightweight JDK image
FROM eclipse-temurin:21-jdk-alpine

# Install Chromium and dependencies
RUN apk update && apk add --no-cache \
    chromium \
    chromium-chromedriver \
    bash \
    curl \
    unzip \
    fontconfig \
    ttf-freefont \
    nss \
    freetype \
    harfbuzz \
    ca-certificates \
    tzdata \
    && rm -rf /var/cache/apk/* \
    && chmod +x /usr/bin/chromedriver

# Set environment variables
ENV CHROME_BIN=/usr/bin/chromium-browser
ENV CHROMEDRIVER_PATH=/usr/bin/chromedriver

# Set working directory
WORKDIR /app

# Copy gradle files first for caching
COPY gradle ./gradle
COPY gradlew .
COPY settings.gradle .
COPY build.gradle .

# Copy source code
COPY src ./src

# Make Gradle wrapper executable
RUN chmod +x ./gradlew

# Build the project (skip tests here)
RUN ./gradlew clean assemble --no-daemon

CMD ["./gradlew", "test", "--no-daemon"]