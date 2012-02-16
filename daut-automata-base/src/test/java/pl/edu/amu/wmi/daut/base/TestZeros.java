package pl.edu.amu.wmi.daut.base;

import junit.framework.TestCase;

/**
* Test klasy AlwaysAcceptingContextChecker.
*/
public class TestZeros extends TestCase {

    /**
* Prosty test klasy AlwaysAcceptingContextChecker.
*/
public final void testZeros() {

        final AutomatonSpecification spec = new NaiveAutomatonSpecification();

        State q0a = spec.addState();
        State q1a = spec.addState();
        State q2a = spec.addState();
        State q3a = spec.addState();
        State q4a = spec.addState();
        State q5a = spec.addState();        
        spec.addTransition(q0a, q0a, new CharTransitionLabel('a'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('b'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('c'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('d'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('e'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('f'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('g'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('h'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('i'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('j'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('k'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('l'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('m'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('n'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('o'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('p'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('q'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('r'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('s'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('t'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('u'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('v'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('w'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('x'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('y'));
        spec.addTransition(q0a, q0a, new CharTransitionLabel('z'));
        spec.addTransition(q0a, q1a, new CharTransitionLabel('0'));
        spec.addTransition(q1a, q2a, new CharTransitionLabel('0'));
        spec.addTransition(q2a, q3a, new CharTransitionLabel('0'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('a'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('b'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('c'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('d'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('e'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('f'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('g'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('h'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('i'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('j'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('k'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('l'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('m'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('n'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('o'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('p'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('q'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('r'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('s'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('t'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('u'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('v'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('w'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('x'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('y'));
        spec.addTransition(q3a, q3a, new CharTransitionLabel('z'));        
        spec.markAsInitial(q0a);
        spec.markAsFinal(q3a);
        final AutomatonByRecursion automaton = new AutomatonByRecursion(spec);
        assertTrue(automaton.accepts("hfju000"));
	assertTrue(automaton.accepts("000hfj"));
        assertTrue(automaton.accepts("abc000def"));
        assertFalse(automaton.accepts("fg00r"));
        assertFalse(automaton.accepts("f00"));
    }
}

