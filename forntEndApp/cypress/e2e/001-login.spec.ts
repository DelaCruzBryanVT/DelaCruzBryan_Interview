describe('Login ', () => {
    it('Login ADMIN', () => {
        let username = 'admin';
        let password = 'root';
        cy.clearLocalStorage();
        cy.visit('/');
        cy.get('[type="text"]').type(username).should('have.value', username);
        cy.get('[type="password"]').type(password).should('have.value', password);
        cy.get('button').should('have.css', 'background-color', 'rgb(76, 175, 80)').click().wait(5000)
        cy.get('.login-form').should('exist');
        cy.get('.login-form').should('be.visible');
    });
});