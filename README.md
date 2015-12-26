# FSM-Prototype
A Finite State Machine prototype.

This prototype is developed base on the example [here](http://www.ai-junkie.com/architecture/state_driven/tut_state3.html) and [here](https://sourcemaking.com/design_patterns/state/java/5).

The core idea of creating a new character with customized actions is:
- Create new character Sprite class
- Create new character Controller class (optional)
- Create new character State classes for action customization
- New Sprite class initializes the transition table of FiniteStateMachine
- New Sprite class binds these new State classes into new FiniteStateMachine class

No original code is modified, we just **create new classes for extension**
