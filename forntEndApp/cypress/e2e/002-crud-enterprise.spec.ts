describe('CRUD ENTERPS', () => {
    it('SAVE RECORD', () => {
        let username = 'admin';
        let password = 'root';
        cy.clearLocalStorage();
        cy.visit('/');
        cy.get('[type="text"]').type(username).should('have.value', username);
        cy.get('[type="password"]').type(password).should('have.value', password);
        cy.get('button').should('have.css', 'background-color', 'rgb(76, 175, 80)').click().wait(5000)
        cy.get('.login-form').should('exist');
        cy.get('.login-form').should('be.visible');
        cy.get('.login-form > :nth-child(1)').click()
        cy.get(':nth-child(2) > .ng-untouched').type('SUMPERMERCADOS AKI')
        cy.get(':nth-child(3) > .ng-untouched').type('ALVARO DE CEVALLOS Y PASAJE ALVEAR')
        cy.get(':nth-child(4) > .ng-untouched').type('2 369 852')
        cy.get('[value="True"]').click()
        cy.get('.btn-success').click()
    });

    it('MODIFY RECORD', () => {
        let username = 'admin';
        let password = 'root';
        cy.clearLocalStorage();
        cy.visit('/');
        cy.get('[type="text"]').type(username).should('have.value', username);
        cy.get('[type="password"]').type(password).should('have.value', password);
        cy.get('button').should('have.css', 'background-color', 'rgb(76, 175, 80)').click().wait(5000)
        cy.get('.login-form').should('exist');
        cy.get('.login-form').should('be.visible');
        cy.get('.login-form > :nth-child(1)').click().wait(2500)
        cy.get(':nth-child(3) > :nth-child(7) > .btn-warning').click().wait(2500)
        cy.get(':nth-child(2) > .ng-untouched').clear().type('SUMPERMERCADOS AKI MODIFY')
        cy.get(':nth-child(3) > .ng-untouched').clear().type('ALVARO DE CEVALLOS Y PASAJE ALVEAR')
        cy.get(':nth-child(4) > .ng-untouched').clear().type('0979267988')
        cy.get('[value="True"]').click()
        cy.get('.btn-success').click()
    });

    it('DELETE RECORD', () => {
        let username = 'admin';
        let password = 'root';
        cy.clearLocalStorage();
        cy.visit('/');
        cy.get('[type="text"]').type(username).should('have.value', username);
        cy.get('[type="password"]').type(password).should('have.value', password);
        cy.get('button').should('have.css', 'background-color', 'rgb(76, 175, 80)').click().wait(5000)
        cy.get('.login-form').should('exist');
        cy.get('.login-form').should('be.visible');
        cy.get('.login-form > :nth-child(1)').click().wait(2500)
        cy.get(':nth-child(3) > :nth-child(7) > .btn-danger').click().wait(2500)
    });

});

// #region TEST API's
describe('TEST API ', () => {

    let urlGet = 'http://localhost:8080/api/enterprise'
    let urlSave = 'http://localhost:8080/api/enterprise'
    let urlRead = 'http://localhost:8080/api/enterprise/1';

    it('TEST API GET', () => {
        cy.request({
            method: "GET",
            url: urlGet,
        }).then(function (response) {
            expect(response.status).to.eq(200)
            expect(response.body).not.null
        })
    })

    it('TEST API GET', () => {
        cy.request({
            method: "GET",
            url: urlSave,
        }).then(function (response) {
            expect(response.status).to.eq(200)
            expect(response.body).not.null
        })
    }) 
})
// #endregion