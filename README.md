# Insta Backend Basic

This is the GitHub repository for the **Insta Backend** project. It serves as the backend for an Insta-like application, enabling users to create and retrieve posts. Below you'll find information about the project, how to get started, and its usage.

## Overview

The **Insta Backend** is a Spring Boot-based application that handles post creation and retrieval for the Insta-like app. It also includes user management features, such as user sign-up, sign-in, and sign-out.

## Features

- **Create New Posts:** Users can create new posts by sending a POST request to `/create/post`. It requires user authentication.
- **Retrieve All Posts:** You can retrieve a list of all posts by sending a GET request to `/post/{id}`.

- **User Management:**
  - **Sign Up:** Users can sign up for the platform using the `/user/signUp` endpoint.
  - **Sign In:** Users can sign in using the `/user/signIn` endpoint.
  - **Sign Out:** Users can sign out using the `/user/signOut` endpoint.

## Technologies Used

The project is built using the following technologies:

- Java
- Spring Boot
- Spring Web
- MySQL
