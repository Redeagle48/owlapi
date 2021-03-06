/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
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
 * Copyright 2011, University of Manchester
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
package org.semanticweb.owlapi.vocab;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.IRI;

/** Represents the facets that can be used for restricting a datatype.
 * 
 * @author Matthew Horridge, The University Of Manchester, Bio-Health
 *         Informatics Group Date: 24-Oct-2006
 * @see org.semanticweb.owlapi.model.OWLFacetRestriction
 * @see org.semanticweb.owlapi.model.OWLDatatypeRestriction */
public enum OWLFacet {
    //@formatter:off
    /** LENGTH */           LENGTH          (Namespaces.XSD, "length",          "length"), 
    /** MIN_LENGTH */       MIN_LENGTH      (Namespaces.XSD, "minLength",       "minLength"), 
    /** MAX_LENGTH */       MAX_LENGTH      (Namespaces.XSD, "maxLength",       "maxLength"), 
    /** PATTERN */          PATTERN         (Namespaces.XSD, "pattern",         "pattern"), 
    /** MIN_INCLUSIVE */    MIN_INCLUSIVE   (Namespaces.XSD, "minInclusive",    ">="), 
    /** MIN_EXCLUSIVE */    MIN_EXCLUSIVE   (Namespaces.XSD, "minExclusive",    ">"), 
    /** MAX_INCLUSIVE */    MAX_INCLUSIVE   (Namespaces.XSD, "maxInclusive",    "<="), 
    /** MAX_EXCLUSIVE */    MAX_EXCLUSIVE   (Namespaces.XSD, "maxExclusive",    "<"), 
    /** TOTAL_DIGITS */     TOTAL_DIGITS    (Namespaces.XSD, "totalDigits",     "totalDigits"), 
    /** FRACTION_DIGITS */  FRACTION_DIGITS (Namespaces.XSD, "fractionDigits",  "fractionDigits"), 
    /** LANG_RANGE */       LANG_RANGE      (Namespaces.RDF, "langRange",       "langRange");
//@formatter:on
    /** all facet iris */
    public final static Set<IRI> FACET_IRIS;
    static {
        Set<IRI> iris = new HashSet<IRI>();
        for (OWLFacet v : values()) {
            iris.add(v.getIRI());
        }
        FACET_IRIS = Collections.unmodifiableSet(iris);
    }
    private final IRI iri;
    private final String shortName;
    private final String symbolicForm;

    OWLFacet(Namespaces ns, String shortName, String symbolicForm) {
        iri = IRI.create(ns.toString(), shortName);
        this.shortName = shortName;
        this.symbolicForm = symbolicForm;
    }

    /** @return local name */
    public String getShortName() {
        return shortName;
    }

    /** @return iri */
    public IRI getIRI() {
        return iri;
    }

    /** @return symbolic form */
    public String getSymbolicForm() {
        return symbolicForm;
    }

    @Override
    public String toString() {
        return shortName;
    }

    /** @return all facet iris */
    public static Set<IRI> getFacetIRIs() {
        return FACET_IRIS;
    }

    /** @param iri
     *            facet IRI
     * @return facet for iri */
    public static OWLFacet getFacet(IRI iri) {
        for (OWLFacet vocabulary : OWLFacet.values()) {
            if (vocabulary.getIRI().equals(iri)) {
                return vocabulary;
            }
        }
        return null;
    }

    /** Gets a facet by its short name.
     * 
     * @param shortName
     *            The short name of the facet.
     * @return The facet or {@code null} if not facet by the specified name
     *         exists. */
    public static OWLFacet getFacetByShortName(String shortName) {
        for (OWLFacet vocabulary : OWLFacet.values()) {
            if (vocabulary.getShortName().equals(shortName)) {
                return vocabulary;
            }
        }
        return null;
    }

    /** @param symbolicName
     *            symbolic name for facet
     * @return facet for name */
    public static OWLFacet getFacetBySymbolicName(String symbolicName) {
        for (OWLFacet vocabulary : OWLFacet.values()) {
            if (vocabulary.getSymbolicForm().equals(symbolicName)) {
                return vocabulary;
            }
        }
        return null;
    }

    /** @return all facets */
    public static Set<String> getFacets() {
        Set<String> result = new HashSet<String>();
        for (OWLFacet v : values()) {
            result.add(v.getSymbolicForm());
        }
        return result;
    }
}
