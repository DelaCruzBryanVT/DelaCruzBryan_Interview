import { defineConfig } from "cypress";

export default defineConfig({
  chromeWebSecurity: false,
  viewportWidth: 1152,
  viewportHeight: 864,
  defaultCommandTimeout: 120000,
  videoUploadOnPasses: false,
  video: false,
  projectId: 'ny4q7p',
  waitForAnimations: true,
  pageLoadTimeout: 300000,
  responseTimeout: 300000,
  trashAssetsBeforeRuns: true,
  retries: 2,
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
    baseUrl: 'http://localhost:4200/',
    env: {
      user:'admin',
      pass:'admin'
    },
    excludeSpecPattern: ['*.js'],
    specPattern: [
      'cypress/e2e/001-login.spec.ts',
      'cypress/e2e/002-crud-enterprise.spec.ts',
    ]
  },
});
