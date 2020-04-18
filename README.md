# The Cotton Factory

**Table of Contents**

- [Instructions]('#-instructions') 
- [Get Started: Dev Environment Setup]('#-environment')
- [Requirements (on Learn)]('https://learn-2.galvanize.com/cohorts/1625/blocks/399/content_files/units/Cotton_Factory')
- [Troubleshooting]('#-troubleshooting')
- [Extra Tips and Advice]('#-tips')


## Description

The Cotton Factory is a company that manufactures cotton clothing of all kinds. They currently use microservices to run their online shopping experience, but they want to rebuild the Products service.

The Products service is responsible for all the products that they sell. It includes the details of each product including names, descriptions, sizes, prices and many other details related to each unique product.

It works with the other services which aren't being updated in this phase: Orders and Accounts.


## Instructions

This exercise is about your role in the CI/CD cycle and understanding the process of continuous integration. 

Your task is to help rebuild the Products service. Everyone in the class is working with the Products service which contains the following products:

* Shirts
* Shoes
* Jackets
* Socks
* Hats
* Slacks
* Skirts
* Dresses

You or your group will be assigned a single product and your task is to implement it and integrate your code with the project.

#### Workflow

During this exercise your workflow should look like this:

0. Create a new feature branch.
1. Use the TDD cycle: write a test, make it pass and refactor.
2. Update your branch!
3. Submit MR/PR to the project repository for code review.
4. Participate in the code review process.

Once your PR is submitted, automated tests will check that your code works.

![](https://imgur.com/zpLEc3R)

Part of the challenge is that during code reviews, you'll need to simultaneously continue working on your next feature, making sure you're keeping your project up-to-date as things are merged by everyone else! This is part of the process of continuous integration.

Instructors will frequently update the project and version tags as the features are developed to deploy the service at the end of the exercise. 

Focus on:

* Tests: Write the strongest tests you can, but start **simple** ..and when you think its simple, **make it simpler**.
* Iteration: Small PRs/MRs. A few small commits with good messages.
* Code review: Discuss PRs, changes and bugs on the issue tracker with your peers during this process on Github.
* Make sure your PR passes the automatic tests!

The ideal PR/MR only updates a couple of files (the test file and the files under test) and only a few lines of code within each. This helps make your code easy to review and decreases the chances of submitting bugs.

This is an opportunity to practice your dev workflow. Your role in the CI/CD process is to develop well-tested code on a regular basis to contribute to frequent application updates. 


## Get Started: How to Set-up Your Dev Environment

**Do not continue until you have forked this repo and have it open in your IDE.**

Remember that EVERYONE IN THE CLASS IS USING THIS CODE BASE. So your settings need to match everyone else's or your code will cause problems for everyone!

#### Create the Database(s)

First, create the databases in MySQL. There are 3 and they should be named: `cottonfactory, cottonfactory_dev and cottonfactory_test`.

#### Update Environment

This application uses spring profiles for dev, prod and test environments. You'll need to ensure you've defined the environment variables to match your local setup.

If you're using Intellij, make sure you've already forked this repository, then:

1. Open the IDE.
2. Duplicate `application-dev.properties` and name it `application.properties`.
3. Update values for: `DB_USER, DB_PASSWORD, DB_HOST` as needed
4. Do the same for `application-test.properties`

The `application.properties` file is ignored by git. This is because when deploying applications, we always want to specify specific versions of the app.


#### Create a New Branch

Your team has been assigned an issue from the issue tracker. Read it thoroughly. When you've decided where you want to start working, **create a new feature branch**. 

For example, if you decide to start with a Hats service test, your first test could be to make sure you don't return `hat_size` field to the user. In this scenario, you might name the feature branch: `feature/hatservice/removesize`.

It's imperative that your feature branches describe exactly what you're coding.

Happy coding!

<p align="center">
![](https://i.redd.it/r9qetbt556k41.png)
</p>


## Troubleshooting

![](https://i.redd.it/ov5ahw52zet41.jpg)

You may also find it handy to update (temporarily)  `build.gradle` to ensure Gradle can grab the environment variables when building the app. Gradle cannot read your environment on it's own so its possible for `gradle test` to fail because of this.

1. Open `build.gradle`
2. Scroll down to the `test` section.
3. Update the environment values on lines 37 and 38:
```
environment "DB_USER", "enter_user_here"
environment "DB_PASSWORD", "enter_password_here"
```
...but remember: this is temporary! Do not commit this or push this change to a PR.


## Tips and Advice

- If you're encountering an error that takes longer than 15 minutes to resolve, create a new issue on the tracker and tag it as a `bug`.
- MOVE ON, KEEP WORKING. Do not wait for a bug issue to be resolved because some issues can take long. 
- Don't forget to keep your branch up-to-date!
- Make sure you're taking the time to see if new bugs are posted. You might be able to help.
- Try to participate in code reviews -- you have to use everyone else's code so it's in your interest to take a look at whats being merged!
