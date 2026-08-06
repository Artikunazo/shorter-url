# Get official node 20 image in alpine version
FROM node:20-alpine AS build

# Enable pnpm
RUN corepack enable && corepack prepare pnpm@9 --activate

# Define workdir
WORKDIR /app

# Copy dependency files
COPY package.json pnpm-lock.yaml* ./

# Install all project dependencies
RUN pnpm install

# Copy all project files to container application
COPY . .

COPY nginx.conf /etc/nginx/conf.d/default.conf

# Build the project
# RUN pnpm run build -- --configuration production
RUN pnpm run build

# Get official nginx image
FROM nginx:alpine

# Copy the build output to nginx default html directory
COPY --from=build /app/dist/shorter-url/browser /usr/share/nginx/html
