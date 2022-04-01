FROM node:latest as build

# Set the working directory
WORKDIR /app

# Add the source code to app
COPY package*.json .

# Install all the dependencies
RUN npm install
COPY . .
# Generate the build of the application
RUN npm run prod


# Stage 2: Serve app with nginx server

# Use official nginx image as the base image
FROM nginx:latest

# Copy the build output to replace the default nginx contents.
COPY ./nginx/nginx.conf /etc/nginx/nginx.conf
COPY --from=build /app/dist/angular-ecommerce/ /usr/share/nginx/html

# Expose port 80

# FROM node:12.18.1
# ENV NODE_ENV=production
# WORKDIR /usr/src/app
# COPY ["package.json", "package-lock.json*", "npm-shrinkwrap.json*", "./"]
# RUN npm install --production
# COPY . .
# EXPOSE 8080
# RUN chown -R node /usr/src/app
# USER node
# CMD [ "node", "server.js" ]
# CMD ["npm", "start"]
