import { test, expect } from '@playwright/test';

test('testITZBund', async ({ page }) => {
  await page.goto('https://itzbund.de');
  await page.getByRole('button', { name: 'Auswahl bestätigen' }).click();
  await page.getByRole('link', { name: 'Lernen Sie uns kennen' }).click();
  await page.locator('a').filter({ hasText: 'Standorte' }).nth(3).click();
  await expect(page.getByText('12 Dienstsitze bundesweit')).toBeVisible();
});