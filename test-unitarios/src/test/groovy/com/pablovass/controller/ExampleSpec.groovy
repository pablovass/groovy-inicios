package com.pablovass.controller

import com.pablovass.domain.Colour
import com.pablovass.domain.Palette
import com.pablovass.domain.Polygon
import com.pablovass.domain.Renderer
import com.pablovass.domain.ShapeFactory
import com.pablovass.domain.TooFewSidesException
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll



class ExampleSpec extends Specification {

def "should be a simple assertation"(){
    expect:
    1==1
}
    def  "should demostrate given-when-then"(){
        given:
        def polygon = new Polygon(4)
        when:
        int side = polygon.numberOfSides
        then:
        side==4
    }
    def "should expect Expeptions"(){
        when:
        new Polygon(0)
        then:
        def exception= thrown (TooFewSidesException)
        exception.numberOfSides==0

    }
    def "should expect and Exception to be thrown for invalid input: #sides"(){
        when:
        new Polygon(sides)
        then:
        def exception= thrown(TooFewSidesException)
        exception.numberOfSides==sides
        where:
        sides<<[-1, 0, 1,2]
    }
    // #sides te deja ver los input y te dice en cual fallo
    def "should be able to create a poligon with #sides sides"(){
        when:
        def polygon =new Polygon(sides)
        then:
        polygon.numberOfSides==sides
        where:
        sides<<[3,4,5,8,14]
    }
    def "should be able to create a poligon with #sides sides (igual que arriba pero resumido el test)"(){
        expect:
        new Polygon(sides).numberOfSides==sides
        where:
        sides << [3,4,5,8,14]
    }

    @Unroll
    def "should demonstrate simple data driven testing. Number of sides: #expected"() {
        expect:
        shape.getNumberOfSides() == expected

        where:
        expected << [3, 4, 5, 8, 14]
        shape = new Polygon(expected)
    }

    def "should demonstrate data tables. Max of #a and #b should be #c"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        1 | 3 || 3
        7 | 4 || 7
        0 | 0 || 0
    }

    def "should be able to mock a concrete class"() {
        given:
        Renderer renderer = Mock()
        @Subject
        def shape = new Polygon(4, renderer)

        when:
        shape.draw()

        then:
        4 * renderer.drawLine()
    }

    def "should be able to use a stub"() {
        given:
        Palette palette = Stub()
        palette.getPrimaryColour() >> Colour.Red
        @Subject
        def renderer = new Renderer(palette)

        expect:
        renderer.getForegroundColour() == Colour.Red
    }

    def "should demonstrate helper methods"() {
        given:
        def renderer = Mock(Renderer)
        def shapeFactory = new ShapeFactory(renderer)

        when:
        def shape = shapeFactory.createDefaultPolygon()

        then:
        checkDefaultShape(shape, renderer)
    }

    private static void checkDefaultShape(Polygon shape, Renderer renderer) {
        assert shape.numberOfSides == 4
        assert shape.renderer == renderer
    }

    def "should demonstrate 'with'"() {
        given:
        def renderer = Mock(Renderer)
        def shapeFactory = new ShapeFactory(renderer)

        when:
        def shape = shapeFactory.createDefaultPolygon()

        then:
        with(shape) {
            numberOfSides == 4
            renderer == renderer
        }
    }

    def "should demonstrate 'verifyAll'"() {
        given:
        def renderer = Mock(Renderer)
        def shapeFactory = new ShapeFactory(renderer)

        when:
        def shape = shapeFactory.createDefaultPolygon()

        then:
        verifyAll(shape) {
            numberOfSides == 4
            it.renderer == renderer
        }
    }

    def "should show specification as documentation"() {
        given: "a palette with red as the primary colour"
        Palette palette = Stub()
        palette.getPrimaryColour() >> Colour.Red

        and: "a renderer initialised with the red palette"
        def renderer = new Renderer(palette)

        expect: "the renderer uses the palette's primary colour as the foreground colour"
        renderer.getForegroundColour() == Colour.Red
    }
}
