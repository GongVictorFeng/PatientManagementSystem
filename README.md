# PatientManagementSystem
A web application for patient management using Spring Boot and React

# Project Structure

* folder `server` holds the backend Spring server
  * run `docker-compose up` to first start the mongodb on `localhost:27017` (make sure you have docker installed, with compose support)
  * run `./gradle bootRun` (or your OS-compatible gradle bootRun command) to start the backend on `localhost:9000`
 
* folder `client` holds the frontend Next.js (React) client
  * run `npm run dev` to start up the React app on `localhost:3000`
 
## Backend Standards
Framework: Spring Boot

Service Architecture:

Follow MVC (Model-View-Controller) design principles.

Use Clean Architecture for decoupling layers:

Domain: Core business entities.

Application: Business logic and use cases.

Adapters: Converters between domain and persistence layers.

Infrastructure: Communication with external resources.
