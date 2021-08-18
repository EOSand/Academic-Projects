# Elijah Sanderson Academic Portolio

# [05/2019 - Java Periodic Table]()
This Java program provides the user with an interactive periodic table which contains relevant data on each element. Atomic number, mass,
critical points, desnity, phase, category, radioactivity, and links to Wikipedia articles are included. 

![](/images/Periodic_table.png)

# [12/2018 - SIR Model Using Vaccinations](https://github.com/EOSand/Academic-Projects/blob/master/SIR_with_Vaccinations.pdf)
In this paper we take the standard SIR model one step further and introduce a vaccination rate to measure the effects it has on the model.
Throughout class we have looked at examples of SIR models which all address the spread of a disease within a contained population given some 
disease length. Our work aimed to introduce a vaccination rate and study it's affect on the intensity and length of the epidemic. We 
introduced a daily vaccination rate of 15% which would be applied to susceptible individuals and cause the patient to become immune after 
three days.

This report was submitted as a final paper for MATH 1550 at WIT

# [10/2018 - Deflection of an electric beam](https://github.com/EOSand/Academic-Projects/blob/master/Deflection_of_an_Electric_Beam.pdf)
This investigation aims to measure the deflection of an electron beam as it passes between a set of parallel charged plates. Using this 
measurement, we will be able to determine the electric field strength between the plates.

This report was submitted as a final paper for MATH 1750 at WIT.

# [05/2018 - Optimization: A method to expand binomials raised to the nth power](https://github.com/EOSand/Academic-Projects/blob/master/Math_IA.pdf)
This investigation aims to find another way to express a binomial without using the binomial expansion. In other words, given a binomial with
positive terms and real power, is there a way to represent this expression with only powers of the terms inside the binomial? We use methods
of optimization and analyzing linear relationships to intuitively and rigorously achieve an expression for the expansion of an arbitrary
binomial. 

This project was submitted as a final assessment for IB HL Mathematics in May of 2018.

# [05/2018 - Finding an unknown variable based on the equation for launch angle](https://github.com/EOSand/Academic-Projects/blob/master/Physics_IA.pdf)
This investigation aims to determine the physical quantity and units of an unknown variable based on the kinematic equation for launch angle.
We notice that the equation for the launch angle of a given projectile, required to hit coordinates **(x,y)** when fired with initial velocity 
**v**, looks quite similar to the quadratic formula. We derive the corresponding quadratic equation from which the previous formula results
and conduct an experiment to nearly understand which physical property the resulting quadratic equation describes. 

This project was submitted as a final assessment for IB HL Physics in May of 2018.


# [Project 1: US Senate Committees](https://github.com/liberatorea94/US-Senate-Committees)
Created by AJ Liberatore (liberatorea94@gmail.com) and Jayden Butts (buttsj@wit.edu). This project had a focus on data collection and data visualization.

## Summary
Created a Tableau story to illustrate the interconnectedness of the US Senate, as well as to illustrate issues with diversity. This was accomplished with:
* Tableau to create an interactive dashboard, allowing users to explore demographics of specific committees compared to the US as a whole
* Tableau Story to create a story with points to guide user through how the dashboard works, as well as the technicality of the network visualization
* Pandas and Numpy to organize and clean Senate committee data so that it may be used in Gephi
* Gephi to create a network illustrating the interconnected nature of the Senate, where nodes are committees and edges are shared members, weighted by quantity of members

## Visualizations

The Tableau dashboard provides insight into Senate demographics compared to the US as a whole, contains bios for each Senator in the 116th US Congress, and most importantly allows the user to dig in and come to their own conclusions. Below is a screenshot of the dashboard.

![](/images/Committee_Dashboard1.png)

Each dot is scaled based on the number of committees and seat of power a Senator holds, and are colored based on their identified party. If the user wishes to view the demographics of a specific group of committees, they may go to the middle of the dashboard and select up to 10 committees they wish to view.

My main work in this project was in collecting and cleaning the Senate committee data in order to create out network visualization, as well as assembling the story in Tableau. Below is the network visualization itself.

![](/images/Committee_Network.png)

Though the viz contains some technical jargon, the story specifies the following:
* There are 136 possible pairs of committees
* There is an average of almost 4 Senators shared among any two committees
* There are only 12 committee pairs which do not share a Senator
* 91% of committee pairs share at least one Senator
* The average committee shares a Senator with over 14 other committees

## Data
The data we used was collected from two places. We used the [demographics and economy section of the Kaiser Family Foundation website](https://www.kff.org/state-category/demographics-and-the-economy/) for up to date US demographics, and we used the [US Senate website](https://www.senate.gov/reference/stats_and_lists.htm) to collect information about Senators and committees.

# [Project 2: PCA Effects on Training Handwritten Digit Classifier](https://github.com/lees19atwit/DS-Final)
Created by Sunny Lee (lees19@wit.edu) and AJ Liberatore (liberatorea94@gmail.com). This project had a focus on dimensionality reduction and classification.

## Summary
The objective of this project was to analyze the effects of dimensionality reduction on training neural networks, specifically to see the effects of PCA dimensionality reduction on a MLPClassifier for recognizing handwritten digits and how dimensionality reduction can help with saving both memory and computation time. 

## Results
After utilizing PCA, it was recognized that the first 100 components captured quite a lot of variance over the entire training set. Below is a graph of the variance against the number of components.

![](/images/variance.png)

Using a reverse transform, we can intuitively see that the first 100 components give a good approximation to the original dataset.

![](/images/mnistreduced.png)

When we used the reduced train and test set, we achieved an accuracy of 95.95% in about 18 seconds while the original train and test set achieved an accuracy of 96.15% in about 64 seconds.

## Data
We used the MNIST Handwritten data set imported with Keras. MNIST comes with 60,000 samples of 28x28 handwritten digits and an additional 10,000 samples as training data. Here are 100 samples of the training data set:

![](/images/mnist.png)
