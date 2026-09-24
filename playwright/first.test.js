const { test, expect } = require('@playwright/test');

test('my first playwright test', async ({ page }) => {
  await page.goto('https://google.com');
  await expect(page).toHaveTitle(/Google/);
  console.log('Test passed! Playwright is working!');
});
