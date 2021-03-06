/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, Clark & Parsia, LLC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, Clark & Parsia, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.clarkparsia.owlapi.explanation;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

/** Explanation generator for a single explanation. */
public interface SingleExplanationGenerator {
    /** Gets the ontology manager.
     * 
     * @return the ontology manager for this explanation generator. */
    OWLOntologyManager getOntologyManager();

    /** Gets the ontology.
     * 
     * @return the ontology according to which the explanations are generated */
    OWLOntology getOntology();

    /** dispose of the reasoners and ontologies.
     * 
     * @return the reasoner */
    // XXX once the interface is changed, uncomment this
    // void dispose();
    /** @return the reasoner associated with this generator. */
    OWLReasoner getReasoner();

    /** Gets the reasoner factory.
     * 
     * @return the reasoner factory used to create fresh reasoners. */
    OWLReasonerFactory getReasonerFactory();

    /** Get a single explanation for an arbitrary class expression, or empty set
     * if the given expression is satisfiable.
     * 
     * @param unsatClass
     *            arbitrary class expression whose unsatisfiability will be
     *            explained
     * @return set of axioms explaining the unsatisfiability of given class
     *         expression, or empty set if the given expression is satisfiable. */
    Set<OWLAxiom> getExplanation(OWLClassExpression unsatClass);
}
