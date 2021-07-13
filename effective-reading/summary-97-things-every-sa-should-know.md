# [97 Things Every Software Architect Should Know](http://www.uni-obuda.hu/users/boraros-bakucz.andras/2014/methodology/97%20Things%20Every%20Software%20Architect%20Should%20Know.pdf)


### 1. Don't put your resume ahead of the requirements (Nitin Borwankar).
### 2. Simplify essential complexity; diminish accidental complexity (Neal Ford).
1. Essential complexity represents the difficulty inherent in any domain problem or functional requirement.
2. Accidental complexity grows from the things we feel we must build to mitigate essential complexity. 
3. It’s the duty of the architect to solve the problems inherent in essential complexity without introducing accidental complexity.
    1. Prefer frameworks derived from working code rather than ones cast down from ivory towers.
    2. Look at the percentage of code you have in a solution that directly addresses the business problem versus code
that merely services the boundary between the application and the users. 

### 3. Chances are, your biggest problem isn’t technical (Mark Ramm).
### 4. Communication is king; clarity and leadership, its humble servants (Mark Richards).
1. The key to effective communication is clarity and leadership.
2. Keep things as simple as possible at the start of a project.
3. Throw away the lengthy Word documents and focus more on getting your ideas across.
4. Create simple diagrams to convey your thoughts. 
5. Record the details of your architectural decisions ([Use Architectural Decision Records](https://adr.github.io/)).
5. Conduct informal whiteboard meetings.
6. Communicate with developers, work with developers, not against them.
7. Gain the respect of your co-workers to work in a healthy and effective environment.

### 5. Application architecture determines application performance (Randy Stafford).
1. Appreciate that application architecture is the primary determinant of application performance
and scalability.
2. If the deployment of an application is insufficiently
architected for the expected load, or if the application’s functional architecture
is too inefficient in its utilization of computing resources, then no amount of
“tuning” will bring about the desired performance and scalability characteristics

### 6. Seek the value in requested capabilities (Einar Landre).
1. Always ask "Why" and understand the real value to address the real problem, and hopefully provide a better and cheaper solution.
2. The focus on value also simplifies prioritization: the most valuable requirements become the driving requirements.
3. Arrange workshops and meetings where the architects’ focus is on customer needs — helping the customers to answer the “why” question.

### 7. Stand Up! (Udi Dahan). 
### 8. Everything will ultimately fail (Michael Nygard).
1. Accept that your system (software, hardware) inevitably fail.
2. Design and implement safe failure modes in advance (see crumple zones).

### 9. You’re negotiating more often than you think (Michael Nygard).
1. Dont make concessions on the first demand.
2. Look for a collaborative solution-finding exercise.
3. We’re trained as engineers, and engineering is all about making tradeoffs.
4. Negotiate win-win solution without being passive aggressive.

### 10. Quantify (Keith Braithwaite).
1. If performance matters, ask for exact numbers: 
    How many? 
    In what period? 
    How often? 
    How soon? 
    Increasing or decreasing? 
    At what rate? 
  Reject “Lots” and “soon” as answers.
2. If performance doesn't matter, ensure for that and then focuse on aspects of the system that are worth paying for.  

### 11. One line of working code is worth 500 of specification (Keith Braithwaite).
1. Design matters, but the fact is that specifications alone have no value. The ultimate goal of a software project is a production system.
2. No design is perfect from the start; all designs need to be modified as they are implemented.
3. Listen to the team who work on implementing your vision or better try to programm it on your own.

### 12. There is no one-size-fits-all solution (Randy Stafford). 
1. Architects must contininuosly develop and exercise "contextual sense".
2. (system architecting) The most important knowledge of software patterns is the knowledge of when
to apply them and when not to apply them depending on the context.
3. (problem analysis) Root cause hypotheses and associated corrective actions during problem analysis depend on the context.
4. **Problem analysis and system architecting requires accumulated contextual sense.**

### 13. It's nenver too early to think about performance (Rebecca Parsons).
1. Strive to begin testing performance as soon as possible from the very begining of the project.
2. Set up performance testing incrementaly.
3. Why is this so important? The biggest reason is that at the very least you know the kinds of changes that made performance fall off a cliff.

### 14. Architecting is about balance (Randy Stafford).
1. Software architecting is about balancing technical requirements with the business requirements of stakeholders in the project.

### 15. Commit-and-run is a crime (Niclas Nilsson).
1. Commit-and-run is a crime because it kills flow and stops the development.
2. Implement autometed tests that will build and check every commit. 
3. Make tests fast. People should not wait for computers, or they will take shortcuts otherwise, which often causes problems for others.
4. Invest time in making the development environment fast to work with.

### 16. to be continued...
