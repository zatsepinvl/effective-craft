# Summary of "The Clean Coder" by Robert C. Martin 

> This list of main statements from the book serves for quick look up after reading to refresh the memory. 
This list doesn't try to substitute reading the book.
Reading the book is necessary to understand some points and eliminate possible ambiguity.

## 1. Professionalism
    
### Taking Responsibility
- Take responsibility and accountability.
- Imagine sometimes that it is your own money burned due to a bug.
- As a professional when you make a mistake, you must clean up the mess.

### Do not harm
- Practise merciless refactoring - remember the Boy Scout rule.
- Software is too complex to create without bugs.
- QA should find nothing.
- You must known it works.
- You must to be able to execute tests on a whim.
- If you want your software to be flexibly, you have to flex it! 
The only way to prove that your software is easy to change to make easy changes to it.

### Work Ethic
- Commit the principles and patterns of software design to memory and strive to conform your software to them.
- It is not your employer's responsibility to give you time you need to learn.
- Do not entrust your career to your employer.
- 40 hours a week are for your employer / 20 hours a week are for you.
- Be conversant with:
    - Design patterns: GOF book, POSA book;
    - Design principles: SOLID;
    - Methods: XP, Scrum, Lean, Kaban, Waterfall, Structured Analysis, Structured Design;
    - Disciplines: TDD, OOD, CI;
    - Artifacts: UML, DFDs, Petri Nets, State Transition Diagrams and Tables.
- Do not stop learning.
- Do not stop practicing.
- Collaborate.
- Be a mentor.
- Know your domain.
- Identify with employer/customer.
- Be humble.
- Never demean another for making a mistake.
- Never ridicule others.

## 2. Saying No
    
### Adversarial Roles
- Professionals speak truth to power.
- Do not hesitate to say no and face confrontation, 
the hard decisions are best made through the confrontation of adversarial roles.
- Do not provide too much details in case of adversarial conversation as it can be an invitation for micro-management.

### High Stakes
- The most important time to say no is when the stakes are highest.
- The higher the stakes, the more valuable "no" becomes.

### Being a "Team Player"
- Keen on being a team player.
- Use every means in your power to help teammates, managers and customer.
- Forget about trying. Either you do or you do not.
- Be open, there is no place or time for passive aggression.

### The Cost of Saying Yes
- Strive to find a way to say YES. But remember that sometimes the only way to get to the right yes is to be unafraid to say no.
- The clients never care as much as you do.

### Code Impossible
- Do not be tempted to be a hero or jedi.
- Never drop your disciplines. It is not the way to solve problems.
- Good code and professionalism are possible.

## 3. Saying Yes

### A Language of Commitment
- Make a commitment effectively:
    1. You say you'll do it.
    2. You mean it.
    3. You actually do it.
- Recognize lack of commitment around you, and in you.
- Change your language of commitment to solve the communication problem.
- Professionals live up to their words.

### Learning How to Say "Yes"
- Instead of committing to do impossible work (or if it depends on someone else), you should commit to these specific actions that bring you closer to the end goal.
- Change expectations as soon as possible.
- Do not abuse the word try. Say it clear, either you will or you wont.
- Do not break disciplines, it only slows you down.
- All commitments we make should be subordinate to the committed disciplines.
- Professionals know their limits.

## 4. Coding

### Preparedness
- Firstly, you must understand what problem you are solving. 
- Secondly, you must understand how to solve that problem.
- Your code must fit well into the existing system.
- You must craft the code in such a way that it reveals your intent.

### Interruptions
- If you are tired or destructed, do not code. Dedication and professionalism are more about discipline that hours.
- Professional developers allocate their personal time in order to ensure that the time spent at office is as productive as possible.
- The professional attitude is a polite willingness to be helpful.

### Creativity
- Remember that creativity breeds creativity.

### Debugging
- It is incumbent upon you as a professional to reduce your debugging time as close to zero as you can get.

### Pacing Yourself
- You must conserve your energy and creativity with the same care.
- Learn your patterns of creativity and brilliance, and take advantage of them rather than work against them.
- Disengagement allows your mind to hunt for solutions in a different and more creative way.
- Sometimes the best way to solve a problem is to go home, eat dinner, watch TV, go to bed, and then wake up the next morning and take a shower.

### Being Late
- Do not incorporate hope into your estimates. Hope is a project killer.
- Do not let anyone else have hope.
- Hold your estimates.
- Do not be tempted to rush.
- Never buckle under pressure and agree to try to make the deadline.
- You should not agree to work overtime unless
    1. You can personally afford it;
    2. It is short term, two weeks or less;
    3. Your boss/manager has a fall-back plan in case the overtime effort fails.
 - Avoid the problem of false delivery by creating an independent definition of "done".
 
### Help
 - No matter how skilled you are, you will certainly benefit from another programmer's thoughts and ideas.
 - As a professional you are honor bound to offer that help whenever it is needed.
 - Fresh perspective can be a profound catalyst for solving problems.
 - As you are honor bound to offer help, you are honor bound to accept help. Be gracious about it.
 - It is unprofessional to remain stuck when help is easily accessible.
 - As a professional you should train less experienced programmers. 
 
## 5. Test Driven Development

### The Jury Is In
- TDD works.

### The Three Laws of TDD
- You are not allowed to write any production code until you have first written a failing unit test.
- You are not allowed to write more of a unit test than is sufficient to fail - and not compiling is failing.
- You are not allowed to write more production code that is sufficient to pass the current failing unit test.

### The Litany Of Benefits
- *Certainty*. You will write dozens of tests every day. If you keep all of them on hand, you will be certain that your code really works.
- *Defect Injection Rate*. There are several facts of defect reduction by IBM, Microsoft and other companies.
- *Courage*. When you have a suit of tests that you trust, then you lose all fear of making changes and cleaning code.
- *Documentation*. The unit tests are documents that describe the lowest-level design of the system.
- *Design*. The need to test first forces you to think about good design.

### What TDD Is Not
- You can still write bad code even if you write your tests first, you can write bad tests.
- No professional developer should ever follow a discipline when that discipline does more harm than good.

## 6. Practicing
- Again, never stop practicing.
- Practice on your own time. It is not your employer job to help you to keep your skills sharp for you.

### The Coding Dojo
- Doing anything quickly requires practice.
- Choose a repertoire of problem/solution paris and execute them over and over again until you know them cold.
- Practice Kata.
- Practise Wasa.
- Practise Randori.

### Broadening Your Experience
- Diverse your experience.
- Contribute to an open-source project.
- Do not use the same language or platform that you use at work.

## 7. Acceptance Testing

### Communicating Requirements
- Remember that a vision of features does not often survive actual contact with the computer.
- Do not succumb to temptation to fall into the trap of premature precision.
- Follow The Uncertainty Principle: The more precise you make your requirements, the less relevant they become as the system is implemented. 
- The uncertainty principle makes hash out of early precision. The requirements _will_ change making that precision moot.
- You must make estimates based on low precision requirements and recognize that those estimates _are estimates_.
- Always include error bars with the estimates so that the business understands the uncertainty (see Chapter 10).
- The solution to premature precision is to defer precision as long as possible and eliminate _late ambiguity_.
- It's your responsibility to make sure that all ambiguity is removed from the requirements.

### Acceptance Tests 
- Acceptance tests define when a requirement is done. They allow you to to know then you are done.
- _Done_ means all code written, all tests pass, QA and stakeholders have accepted. Done.
- You must work with stakeholders and QA to ensure that the automated tests are a complete specification of done.
- You must ensure that all parties know what is about to be built.
- Acceptance tests should _always_ be automated. The reason is simple: cost.
- It's your job (as a developer) to connect the acceptance tests to the system, and then to make those tests pass.
- It's your job to negotiate with the test author for a better test.
- Never take the passive-aggressive option and say to yourself, "Well, that's what the test says, so that's what I'm going to do".
- The primary purpose of acceptance tests is to formally document the design, structure, and behavior of the system. They are written by the business for the business.
- Test through the right interface. Separate testing of business rules from testing GUI. 
- Keep the GUI tests to a minimum. They are fragile, because the GUI is volatile.
- Include the acceptance tests into CI/CD systems.
- A broken build in the CI system should be viewed as an emergency, as "stop the presses" event.

## 8. Testing Strategies

### QA Should Find Nothing
- It's your goal as a professional developer that QA find nothing wrong.
- QA and development team should be working together.
- QA team gather the requirements from the business and writes the corner, boundary, and unhappy-path tests.
- QA team should identify the actual behavior of the system and report it back to development and business.

### The Test Automation Pyramid
![The test automation pyramid](assetslean_coder_the_test_automation_pyramid.png "The test automation pyramid")

#### Unit Tests
- Intended to specify system at the lowest level.
- Written by developers for developers, in programming language of the system.
- Cover unhappy-path cases as well.
- Executed as part of CI/CD

#### Component Tests
- Intended to be read and interpreted by business.
- Written by QA and Business with assistance from development.
- Cover component functionality only with mocking and test-doubling dependencies.
- Executed as part of CI/CD

#### Integration Tests
- Written by developers.
- Cover the architectural structure of the system, not business rules. 
  Ensure that all components connected and clearly communicate with each other.
- Can include throughout and performance tests.
- Executed periodically (nightly, weekly, etc.). 

#### System Tests
- Written by architects and tech leads.
- The ultimate integration tests.
- Ensure correct system construction.

#### Manual Exploratory Tests
- Performed by everyone manually.
- Ensure that system behaves well under human operation.
- Give a way to creatively find as many bugs as possible.

## 9. Time Management

### Meetings
- Meetings are necessary and huge time wasters. 
- Meetings spend not only your time but also your project's time,
 your employer's time, your employer's  money.
- Remember that it's only you who is responsible for managing your time.

#### Declining
- You should politely resist attending meetings that don't have an immediate 
 and significant benefit for your job you are doing now.
- Ask your team and manager for help to decide whether you should attend a meeting.
- One of the most important duties of your manager is to keep you out of meetings.

#### Leaving
- When the meeting gets boring, leave. Find a way to politely exit that meeting.

#### Have an Agenda and a Goal
- Make sure you know agenda, and a goal of a meeting you are asked to go. 
- If the agenda has been high jacked during the meeting, request that the new topic be tabled and the agenda be followed.

#### Stand-Up Meetings
- Each participant should require no more than **one minute** to answer the questions:
    - What did I do yesterday?
    - What am I going to do today?
    - What's in my way?

#### Iteration Planning Meetings
- Select the backlog items that will be executed in the next iteration.
    - Estimates should already be done.
    - Assessment of business value should already be done.
    - (In really good orgs) The acceptance/component tests should already be written or sketched out.
- Discuss briefly each candidate backlog item and then either select or reject it.
    - No more than 5-10 minutes on each item.
- Ideally, this meeting should take no more than 5% of the total work time in the iteration.

#### Iteration Retrospective and Demo
- Iteration Retrospective
    - Conducted at the end of each iteration.
    - Discuss what went right and what went wrong.
    - No more than 20 minutes.
- Demo
    - Stakeholders see a demo of the newly working features.
    - No more than 25 minutes.
- Schedule them before quitting time on the last day of the iteration.
- Remember, it's only been a week or two so there shouldn't be all that uch to talk about.

#### Arguments/Disagreements
- _"Any argument that can't be settled in five minutes can't be settled by arguing."_ - Kent Beck.
- Never agree just to end the argument, and then sabotage the result by refusing to engage in the solution. 
If you agree, then you _must_ engage.
- Data matters in technical arguments. Without data, any argument that doesn't forge agreement within 
a few minutes simple won't ever forge agreement.
- You can get the data by running experiments, simulation, modeling.
- Sometimes it's OK just to flip a coin to choose one of the two paths.Then agree on a time as well as a set of criteria to help 
determine when the chosen path should be abandoned.
- If an argument must truly be settled:
    1. Ask each of the arguers to present their case in five minutes or less.
    2. Have the team vote.
    3. The whole meeting will take less than fifteen minutes.

### Focus-Manna
- Programming is an intellectual exercise that requires extended period of concentration and focus.
- Focus-Manna is a unit for measuring how efficient you can concentrate and write code.
- Professional developers learn to manage their time to take advantage of their focus-manna.
- Meetings, worry and distractions consume much focus-manna.

#### Sleep
- Professional developers manage their sleep schedule to ensure that they topped up their focus-manna by the 
time they get to work in the morning.

#### Caffeine
- There is no doubt that some of us can make more efficient use of our focus-manna by consuming **moderate** amounts of caffeine.
But take care. Caffeine usage and tolerance is a personal thing.

#### Recharging
- Focus-manna can be partially recharged by de-focussing: long walk, chat with friends or just looking out a window.
- When you are tired, it's better to take 30-60 minutes to de-focus.

#### Muscle Focus
- Just do physical exercises every day for at least 20 minutes. 
- Whatever the activity, there is something abut activities that focus on muscles that enhances the ability to work with your mind.

#### Input versus Output
- Balance creativity output _like coding_ with appropriate input _like reading of science fiction_.
- [Note] Creative input breeds creative output.

### Time Boxing and Tomatoes
- [Pomodoro Technique](https://francescocirillo.com/pages/pomodoro-technique).
    - Pick a task from a todo list.
    - Set timer for 25 minutes and focus only on the task.
    - While that timer is running, you let **nothing** interfere with what you are doing.
    - Regardless of the interruption (phone call, skype call, whatever), you simply defer it until the timer dings.
    - When the tomato timer dings you stop what you are doing **immediately**.
    - Then you deal with any interruptions that occurred during the tomato.
    - Then you take a break of five minutes or so.
    - Repeat. 
- It is within tomatoes that you get real work done.
- You can count finished tomatoes and chart them to see your velocity.
- The real benefit of the technique is that 25-minute windows of productive time that you aggressively defend against all interruptions.

### Avoidance
#### Priority Inversion
- Whatever the reason, don't try to find ways to avoid doing the real work. Don't do _priority inversion_.
- Professionals evaluate the priority of each task, disregarding their personal fears and desires, and execute those tasks in priority order.

### Blind Alleys
- Software craftmen have to make decisions. Sometimes chosen technical pathways lead to nowhere. These are blind alleys. 
- You should quickly realize when you are in one, and have the courage to back out.
- The Rule of Holes: When you are in one, stop digging.
- Professionals keep an open mind about other ideas so that when they hit a head end they still have other options.

### Marches, Bogs, Swamps and Other Messes
- Professionals fear messes far more than they fear blind alleys. They are always on the lookout for messes that start to grow without bound, 
and will extend all necessary effort to escape from them as early and as quickly as possible.
- Knowing you are in a swamp and moving forward is the worst kind of priority inversion.

### Conclusion
- Be diligent in the management of your time and focus.
- Fight _priority inversion_ as a matter of honor.
- Be open-minded about alternate solutions.
- Never become so vested in a solution that you can't abandon it.
- Be always of the lookout for growing messes.

## 10. Estimation
### What is an Estimate?
#### A Commitment
- Professionals don't make commitments unless they _know_ they can achieve them.
- You are honor bound to decline to make a commitment to something that you aren't certain you can do.
- Commitment is about _certainty_. 
- Missing a commitment is an act of dishonesty only slightly less onerous than an overt lie. 

#### An Estimate
- An estimate is a guess. No commitment is implied. No promise is made.
- Understand the true nature of an estimate: Estimate is not a number. An estimate is a distribution.

#### Implied Commitments
- Professionals draw a clear distinction between estimates and commitments.
- Professionals communicate the probability distribution of their estimates as clearly as possible, 
so managers can make appropriate plans.

### PERT
- PERT - Program Evaluation and Review Technique - the scheme that provides a way to convert estimates into 
probability distribution suitable for managers.
- When you estimate a task, you provide three numbers:
    1. O: Optimistic Estimate - when absolutely everything went right. Should be less than 1% chance of occurrence.
    2. N: Normal Estimate - the greatest chance of success.
    3. P: Pessimistic Estimate - when absolutely everything went wrong. Should be less than 1% chance of success.
- Equations

| Name                                                            |  Equation              |
|-----------------------------------------------------------------|------------------------|
| Expected duration of the task                                   | _μ = (O + 4N + P) / 6_ |
| Standard deviation of the probability distribution for the task | _σ = (P - O) / 6_      |

- Sum all expected durations to get the _estimated_ schedule: _μ<sub>sequence</sub> = sum( μ<sub>task</sub> )_.
- Calculate deviation: _σ<sub>sequence</sub> = sqrt(sum(σ<sub>task</sub>)^2))_.
- Example:

| Task  | Optimistic | Nominal | Pessimistic |  μ  |  σ  |
|-------|------------|---------|-------------|-----|-----|
| Alpha | 1          | 2       | 12          | 4.2 | 1.8 |
| Beta  | 1          | 1.5     | 14          | 3.5 | 2.2 |
| Gamma | 3          | 6.25    | 11          | 6.5 | 1.3 |

- So that
    - Expended duration - _μ<sub>sequence</sub> = sum( μ<sub>task</sub> )_ ~ 14 days (14.2)
    - Deviation - _σ<sub>sequence</sub> = sqrt(sum(σ<sub>task</sub>)^2))_ ~ 3 days (3.13)
    - But it also could take 17 days (μ<sub>sequence</sub> + 1σ) and even 20 days (μ<sub>sequence</sub> + 2σ).
- The uncertainty in the tasks compounds in a way that adds realism to the plan.
- Software professionals are very careful to set reasonable expectations despite the pressure to _try_ to go fast.

### Estimating Tasks
- The most important estimation resource you have are the people around you.

#### Wideband Delphi
- A team of people assemble, discuss a task, estimate the task, and iterate the discussion and estimation until they reach agreement.
- There are several low-overhead approaches like _Flying Fingers_, _Planning Poker_, _Affinity Estimation_, _Trivariate Estimates_.

##### Flying Fingers
- Everybody sits around a table. Participants put their hands below it and raise 0 to 5 fingers as their task duration estimate. 
The moderator counts 1-2-3, and all the participants show their hands at once. If everyone agrees, go on to the next task. 
Otherwise continue the discussion. Repeat until all agree.
- The scale of the estimate is decided on at the beginning of the meeting.

##### Planning Poker
- For each member of the estimation team, deal a hand of cards with different numbers on them (e.g. 0-5 or 1,3,5,10).
Pick a task and discuss it.
Then everyone picks a card that matches their estimate and hold it up with the back facing outward. 
Then everyone shows their cards. If there is agreement, accept the estimate, otherwise discuss.
 
##### Affinity Estimation
- All the tasks are written onto cards without estimates. Do not talk. 
Simply start sorting cards relative to one another: longer to the right, smaller to the left.
Anyone can move any card ay any time. Any card moved more than _n_ times is set aside for discussion.
Then discuss the order to gain consensus. Then draw lines between cards that represent bucket sizes.
Buckets might be in days, weeks or points (e.g. 1,2,3,5,8).

##### Trivariate Estimates
- Use these approaches to create estimates according PERT (pessimistic, normal, optimistic).

### The Law of Large Number
- Estimates are fraught with error. That's why they are called estimates.
- If you break up a large task into many smaller tasks and estimate them independently, 
the sum of the estimates of the small tasks will be more accurate than a single estimate of the large task.

### Conclusion
- Don't make promises that you can't keep.
- Provide probabilistic estimates that describe the expected completion time and the likely variance.
- Work with the team to make estimates using the mentioned techniques.

## 11. Pressure
- Be calm and decisive under pressure. As the pressure grows adhere to training and disciplines.
- The best way to say calm under the pressure is to avoid the situations that cause pressure (no pressure causing situations no pressure :).

### Avoiding Pressure

#### Commitments
- Do not accept unrealistic commitments that make a lot of pressure.
- Professionals are honor bound to help the business find a way to meet the commitments made for them by the business. 
However, they are _not_ honor bound to accept the commitments.

#### Staying Clean
- Do not succumb to the temptation to create a mess in order to move quickly. Dirty always means slow.
- Do not spend endless hours polishing code, just don't tolerate messes.

#### Crisis Discipline
- Do not abandon your disciplines during the crisis.
- Choose disciplines that you feel comfortable following in a crisis. _Then follow them all the time_.  

### Handling Pressure

#### Don't Panic
- Never rush. Instead, slow down. 
- Think the problem through and drive towards the best possible outcome at a steady pace.

#### Communicate
- Let your team and your superiors know that you are in trouble, tell them your best plans and ask them for guidance.
- Avoid creating surprises. Surprises multiply the pressure by ten. 

#### Rely on Your Disciplines
- Trust your disciplines. There are not the times to question or abandon them.
- The only way through the pressure cooker is to rely on what you already know works - your disciplines.

#### Get Help
- Pair program.
- Ask for help, and by the same token, offer to pair with someone who is in trouble. 

### Conclusion
- The trick to handling pressure is to avoid it when you can by: 
    - managing commitments,
    - following your disciplines,
    - keeping clean,
- and weather it when you can't by:
    - staying calm,
    - communicating,
    - following your disciplines,
    - getting help.

## 12. Collaboration
- :tbd

